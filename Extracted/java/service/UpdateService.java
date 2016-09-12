.class public Lorg/adaway/service/UpdateService;
.super Lcom/commonsware/cwac/wakeful/WakefulIntentService;
.source "UpdateService.java"


# static fields
.field public static final EXTRA_BACKGROUND_EXECUTION:Ljava/lang/String; = "org.adaway.BACKGROUND_EXECUTION"

.field private static final UPDATE_NOTIFICATION_ID:I = 0xa


# instance fields
.field private mApplyAfterCheck:Z

.field private mBackgroundExecution:Z

.field private mNotificationManager:Landroid/app/NotificationManager;

.field private mNumberOfDownloads:I

.field private mNumberOfFailedDownloads:I

.field private mService:Landroid/content/Context;


# direct methods
.method public constructor <init>()V
    .registers 2

    .prologue
    .line 69
    const-string v0, "AdAwayUpdateService"

    invoke-direct {p0, v0}, Lcom/commonsware/cwac/wakeful/WakefulIntentService;-><init>(Ljava/lang/String;)V

    .line 70
    return-void
.end method

.method private cancelUpdateNotification()V
    .registers 3

    .prologue
    .line 282
    iget-object v0, p0, Lorg/adaway/service/UpdateService;->mNotificationManager:Landroid/app/NotificationManager;

    const/16 v1, 0xa

    invoke-virtual {v0, v1}, Landroid/app/NotificationManager;->cancel(I)V

    .line 283
    return-void
.end method

.method private checkForUpdates()I
    .registers 19

    .prologue
    .line 137
    const/4 v12, 0x0

    .line 139
    .local v12, "updateAvailable":Z
    const/4 v11, 0x4

    .line 141
    .local v11, "returnCode":I
    move-object/from16 v0, p0

    iget-object v13, v0, Lorg/adaway/service/UpdateService;->mService:Landroid/content/Context;

    invoke-static {v13}, Lorg/adaway/util/Utils;->isAndroidOnline(Landroid/content/Context;)Z

    move-result v13

    if-eqz v13, :cond_15b

    .line 143
    const/4 v13, 0x0

    move-object/from16 v0, p0

    iput v13, v0, Lorg/adaway/service/UpdateService;->mNumberOfFailedDownloads:I

    .line 144
    const/4 v13, 0x0

    move-object/from16 v0, p0

    iput v13, v0, Lorg/adaway/service/UpdateService;->mNumberOfDownloads:I

    .line 147
    move-object/from16 v0, p0

    iget-object v13, v0, Lorg/adaway/service/UpdateService;->mService:Landroid/content/Context;

    invoke-static {v13}, Lorg/adaway/provider/ProviderHelper;->getEnabledHostsSourcesCursor(Landroid/content/Context;)Landroid/database/Cursor;

    move-result-object v9

    .line 150
    .local v9, "enabledHostsSourcesCursor":Landroid/database/Cursor;
    if-eqz v9, :cond_f6

    invoke-interface {v9}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v13

    if-eqz v13, :cond_f6

    .line 153
    :cond_26
    move-object/from16 v0, p0

    iget v13, v0, Lorg/adaway/service/UpdateService;->mNumberOfDownloads:I

    add-int/lit8 v13, v13, 0x1

    move-object/from16 v0, p0

    iput v13, v0, Lorg/adaway/service/UpdateService;->mNumberOfDownloads:I

    .line 156
    const-string v13, "url"

    invoke-interface {v9, v13}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v13

    invoke-interface {v9, v13}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v3

    .line 158
    .local v3, "currentUrl":Ljava/lang/String;
    const-string v13, "last_modified_local"

    invoke-interface {v9, v13}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v13

    invoke-interface {v9, v13}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v4

    .line 163
    .local v4, "currentLastModifiedLocal":J
    :try_start_44
    const-string v13, "AdAway"

    new-instance v14, Ljava/lang/StringBuilder;

    invoke-direct {v14}, Ljava/lang/StringBuilder;-><init>()V

    const-string v15, "Checking hosts file: "

    invoke-virtual {v14, v15}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v14

    invoke-virtual {v14, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v14

    invoke-virtual {v14}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v14

    invoke-static {v13, v14}, Lorg/adaway/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)V

    .line 166
    new-instance v10, Ljava/net/URL;

    invoke-direct {v10, v3}, Ljava/net/URL;-><init>(Ljava/lang/String;)V

    .line 167
    .local v10, "mURL":Ljava/net/URL;
    invoke-virtual {v10}, Ljava/net/URL;->openConnection()Ljava/net/URLConnection;

    move-result-object v2

    .line 168
    .local v2, "connection":Ljava/net/URLConnection;
    const/16 v13, 0x3a98

    invoke-virtual {v2, v13}, Ljava/net/URLConnection;->setConnectTimeout(I)V

    .line 169
    const/16 v13, 0x7530

    invoke-virtual {v2, v13}, Ljava/net/URLConnection;->setReadTimeout(I)V

    .line 171
    invoke-virtual {v2}, Ljava/net/URLConnection;->getLastModified()J

    move-result-wide v6

    .line 173
    .local v6, "currentLastModifiedOnline":J
    const-string v13, "AdAway"

    new-instance v14, Ljava/lang/StringBuilder;

    invoke-direct {v14}, Ljava/lang/StringBuilder;-><init>()V

    const-string v15, "mConnectionLastModified: "

    invoke-virtual {v14, v15}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v14

    invoke-virtual {v14, v6, v7}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v14

    const-string v15, " ("

    invoke-virtual {v14, v15}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v14

    move-object/from16 v0, p0

    iget-object v15, v0, Lorg/adaway/service/UpdateService;->mService:Landroid/content/Context;

    invoke-static {v15, v6, v7}, Lorg/adaway/util/DateUtils;->longToDateString(Landroid/content/Context;J)Ljava/lang/String;

    move-result-object v15

    invoke-virtual {v14, v15}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v14

    const-string v15, ")"

    invoke-virtual {v14, v15}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v14

    invoke-virtual {v14}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v14

    invoke-static {v13, v14}, Lorg/adaway/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 181
    const-string v13, "AdAway"

    new-instance v14, Ljava/lang/StringBuilder;

    invoke-direct {v14}, Ljava/lang/StringBuilder;-><init>()V

    const-string v15, "mCurrentLastModified: "

    invoke-virtual {v14, v15}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v14

    invoke-virtual {v14, v4, v5}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v14

    const-string v15, " ("

    invoke-virtual {v14, v15}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v14

    move-object/from16 v0, p0

    iget-object v15, v0, Lorg/adaway/service/UpdateService;->mService:Landroid/content/Context;

    invoke-static {v15, v4, v5}, Lorg/adaway/util/DateUtils;->longToDateString(Landroid/content/Context;J)Ljava/lang/String;

    move-result-object v15

    invoke-virtual {v14, v15}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v14

    const-string v15, ")"

    invoke-virtual {v14, v15}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v14

    invoke-virtual {v14}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v14

    invoke-static {v13, v14}, Lorg/adaway/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 190
    invoke-virtual {v2}, Ljava/net/URLConnection;->connect()V

    .line 191
    invoke-virtual {v2}, Ljava/net/URLConnection;->getInputStream()Ljava/io/InputStream;

    .line 194
    cmp-long v13, v6, v4

    if-lez v13, :cond_de

    .line 195
    const/4 v12, 0x1

    .line 199
    :cond_de
    move-object/from16 v0, p0

    iget-object v13, v0, Lorg/adaway/service/UpdateService;->mService:Landroid/content/Context;

    const-string v14, "_id"

    invoke-interface {v9, v14}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v14

    invoke-interface {v9, v14}, Landroid/database/Cursor;->getInt(I)I

    move-result v14

    int-to-long v14, v14

    invoke-static {v13, v14, v15, v6, v7}, Lorg/adaway/provider/ProviderHelper;->updateHostsSourceLastModifiedOnline(Landroid/content/Context;JJ)V
    :try_end_f0
    .catch Ljava/lang/Exception; {:try_start_44 .. :try_end_f0} :catch_123

    .line 217
    .end local v2    # "connection":Ljava/net/URLConnection;
    .end local v6    # "currentLastModifiedOnline":J
    .end local v10    # "mURL":Ljava/net/URL;
    :goto_f0
    invoke-interface {v9}, Landroid/database/Cursor;->moveToNext()Z

    move-result v13

    if-nez v13, :cond_26

    .line 221
    .end local v3    # "currentUrl":Ljava/lang/String;
    .end local v4    # "currentLastModifiedLocal":J
    :cond_f6
    if-eqz v9, :cond_101

    invoke-interface {v9}, Landroid/database/Cursor;->isClosed()Z

    move-result v13

    if-nez v13, :cond_101

    .line 222
    invoke-interface {v9}, Landroid/database/Cursor;->close()V

    .line 226
    :cond_101
    move-object/from16 v0, p0

    iget v13, v0, Lorg/adaway/service/UpdateService;->mNumberOfDownloads:I

    move-object/from16 v0, p0

    iget v14, v0, Lorg/adaway/service/UpdateService;->mNumberOfFailedDownloads:I

    if-ne v13, v14, :cond_112

    move-object/from16 v0, p0

    iget v13, v0, Lorg/adaway/service/UpdateService;->mNumberOfDownloads:I

    if-eqz v13, :cond_112

    .line 227
    const/4 v11, 0x6

    .line 240
    .end local v9    # "enabledHostsSourcesCursor":Landroid/database/Cursor;
    :cond_112
    :goto_112
    if-eqz v12, :cond_115

    .line 241
    const/4 v11, 0x3

    .line 245
    :cond_115
    move-object/from16 v0, p0

    iget-object v13, v0, Lorg/adaway/service/UpdateService;->mService:Landroid/content/Context;

    sget-object v14, Lorg/adaway/util/Constants;->ANDROID_SYSTEM_ETC_HOSTS:Ljava/lang/String;

    invoke-static {v13, v14}, Lorg/adaway/util/ApplyUtils;->isHostsFileCorrect(Landroid/content/Context;Ljava/lang/String;)Z

    move-result v13

    if-nez v13, :cond_122

    .line 246
    const/4 v11, 0x5

    .line 249
    :cond_122
    return v11

    .line 205
    .restart local v3    # "currentUrl":Ljava/lang/String;
    .restart local v4    # "currentLastModifiedLocal":J
    .restart local v9    # "enabledHostsSourcesCursor":Landroid/database/Cursor;
    :catch_123
    move-exception v8

    .line 206
    .local v8, "e":Ljava/lang/Exception;
    const-string v13, "AdAway"

    new-instance v14, Ljava/lang/StringBuilder;

    invoke-direct {v14}, Ljava/lang/StringBuilder;-><init>()V

    const-string v15, "Exception while downloading from "

    invoke-virtual {v14, v15}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v14

    invoke-virtual {v14, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v14

    invoke-virtual {v14}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v14

    invoke-static {v13, v14, v8}, Lorg/adaway/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 208
    move-object/from16 v0, p0

    iget v13, v0, Lorg/adaway/service/UpdateService;->mNumberOfFailedDownloads:I

    add-int/lit8 v13, v13, 0x1

    move-object/from16 v0, p0

    iput v13, v0, Lorg/adaway/service/UpdateService;->mNumberOfFailedDownloads:I

    .line 211
    move-object/from16 v0, p0

    iget-object v13, v0, Lorg/adaway/service/UpdateService;->mService:Landroid/content/Context;

    const-string v14, "_id"

    invoke-interface {v9, v14}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v14

    invoke-interface {v9, v14}, Landroid/database/Cursor;->getInt(I)I

    move-result v14

    int-to-long v14, v14

    const-wide/16 v16, 0x0

    invoke-static/range {v13 .. v17}, Lorg/adaway/provider/ProviderHelper;->updateHostsSourceLastModifiedOnline(Landroid/content/Context;JJ)V

    goto :goto_f0

    .line 231
    .end local v3    # "currentUrl":Ljava/lang/String;
    .end local v4    # "currentLastModifiedLocal":J
    .end local v8    # "e":Ljava/lang/Exception;
    .end local v9    # "enabledHostsSourcesCursor":Landroid/database/Cursor;
    :cond_15b
    move-object/from16 v0, p0

    iget-boolean v13, v0, Lorg/adaway/service/UpdateService;->mBackgroundExecution:Z

    if-nez v13, :cond_163

    .line 232
    const/4 v11, 0x7

    goto :goto_112

    .line 234
    :cond_163
    const-string v13, "AdAway"

    const-string v14, "Should not happen! In background execution is no connection available!"

    invoke-static {v13, v14}, Lorg/adaway/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_112
.end method

.method private showUpdateNotification()V
    .registers 16

    .prologue
    const v14, 0x7f080099

    const/high16 v13, 0x7f080000

    const/4 v12, 0x0

    .line 256
    const v4, 0x7f020085

    .line 257
    .local v4, "icon":I
    new-instance v10, Ljava/lang/StringBuilder;

    invoke-direct {v10}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p0, v13}, Lorg/adaway/service/UpdateService;->getString(I)Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    const-string v11, ": "

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {p0, v14}, Lorg/adaway/service/UpdateService;->getString(I)Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    .line 259
    .local v7, "tickerText":Ljava/lang/CharSequence;
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v8

    .line 261
    .local v8, "when":J
    invoke-virtual {p0}, Lorg/adaway/service/UpdateService;->getApplicationContext()Landroid/content/Context;

    move-result-object v3

    .line 262
    .local v3, "context":Landroid/content/Context;
    new-instance v10, Ljava/lang/StringBuilder;

    invoke-direct {v10}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p0, v13}, Lorg/adaway/service/UpdateService;->getString(I)Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    const-string v11, ": "

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {p0, v14}, Lorg/adaway/service/UpdateService;->getString(I)Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 264
    .local v2, "contentTitle":Ljava/lang/CharSequence;
    const v10, 0x7f08009a

    invoke-virtual {p0, v10}, Lorg/adaway/service/UpdateService;->getString(I)Ljava/lang/String;

    move-result-object v1

    .line 266
    .local v1, "contentText":Ljava/lang/CharSequence;
    new-instance v10, Landroid/support/v4/app/NotificationCompat$Builder;

    invoke-direct {v10, v3}, Landroid/support/v4/app/NotificationCompat$Builder;-><init>(Landroid/content/Context;)V

    invoke-virtual {v10, v4}, Landroid/support/v4/app/NotificationCompat$Builder;->setSmallIcon(I)Landroid/support/v4/app/NotificationCompat$Builder;

    move-result-object v10

    invoke-virtual {v10, v2}, Landroid/support/v4/app/NotificationCompat$Builder;->setContentTitle(Ljava/lang/CharSequence;)Landroid/support/v4/app/NotificationCompat$Builder;

    move-result-object v10

    invoke-virtual {v10, v7}, Landroid/support/v4/app/NotificationCompat$Builder;->setTicker(Ljava/lang/CharSequence;)Landroid/support/v4/app/NotificationCompat$Builder;

    move-result-object v10

    invoke-virtual {v10, v8, v9}, Landroid/support/v4/app/NotificationCompat$Builder;->setWhen(J)Landroid/support/v4/app/NotificationCompat$Builder;

    move-result-object v10

    const/4 v11, 0x1

    invoke-virtual {v10, v11}, Landroid/support/v4/app/NotificationCompat$Builder;->setOngoing(Z)Landroid/support/v4/app/NotificationCompat$Builder;

    move-result-object v10

    invoke-virtual {v10, v1}, Landroid/support/v4/app/NotificationCompat$Builder;->setContentText(Ljava/lang/CharSequence;)Landroid/support/v4/app/NotificationCompat$Builder;

    move-result-object v5

    .line 270
    .local v5, "mBuilder":Landroid/support/v4/app/NotificationCompat$Builder;
    new-instance v6, Landroid/content/Intent;

    const-class v10, Lorg/adaway/ui/BaseActivity;

    invoke-direct {v6, p0, v10}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 271
    .local v6, "notificationIntent":Landroid/content/Intent;
    invoke-static {p0, v12, v6, v12}, Landroid/app/PendingIntent;->getActivity(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;

    move-result-object v0

    .line 273
    .local v0, "contentIntent":Landroid/app/PendingIntent;
    invoke-virtual {v5, v0}, Landroid/support/v4/app/NotificationCompat$Builder;->setContentIntent(Landroid/app/PendingIntent;)Landroid/support/v4/app/NotificationCompat$Builder;

    .line 275
    iget-object v10, p0, Lorg/adaway/service/UpdateService;->mNotificationManager:Landroid/app/NotificationManager;

    const/16 v11, 0xa

    invoke-virtual {v5}, Landroid/support/v4/app/NotificationCompat$Builder;->build()Landroid/app/Notification;

    move-result-object v12

    invoke-virtual {v10, v11, v12}, Landroid/app/NotificationManager;->notify(ILandroid/app/Notification;)V

    .line 276
    return-void
.end method


# virtual methods
.method public doWakefulWork(Landroid/content/Intent;)V
    .registers 8
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    .line 103
    iget-object v2, p0, Lorg/adaway/service/UpdateService;->mService:Landroid/content/Context;

    invoke-static {v2}, Lorg/adaway/util/Utils;->isInForeground(Landroid/content/Context;)Z

    move-result v2

    if-nez v2, :cond_b

    .line 104
    invoke-direct {p0}, Lorg/adaway/service/UpdateService;->showUpdateNotification()V

    .line 107
    :cond_b
    iget-object v2, p0, Lorg/adaway/service/UpdateService;->mService:Landroid/content/Context;

    iget-object v3, p0, Lorg/adaway/service/UpdateService;->mService:Landroid/content/Context;

    const v4, 0x7f080099

    invoke-virtual {v3, v4}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v3

    iget-object v4, p0, Lorg/adaway/service/UpdateService;->mService:Landroid/content/Context;

    const v5, 0x7f08009a

    invoke-virtual {v4, v5}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v4

    const/4 v5, 0x0

    invoke-static {v2, v3, v4, v5}, Lorg/adaway/ui/BaseActivity;->setStatusBroadcast(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;I)V

    .line 110
    invoke-direct {p0}, Lorg/adaway/service/UpdateService;->checkForUpdates()I

    move-result v0

    .line 112
    .local v0, "result":I
    const-string v2, "AdAway"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Update Check result: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Lorg/adaway/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 114
    invoke-direct {p0}, Lorg/adaway/service/UpdateService;->cancelUpdateNotification()V

    .line 117
    const/4 v2, 0x3

    if-ne v0, v2, :cond_51

    iget-boolean v2, p0, Lorg/adaway/service/UpdateService;->mApplyAfterCheck:Z

    if-eqz v2, :cond_51

    .line 119
    iget-object v2, p0, Lorg/adaway/service/UpdateService;->mService:Landroid/content/Context;

    const-class v3, Lorg/adaway/service/ApplyService;

    invoke-static {v2, v3}, Lcom/commonsware/cwac/wakeful/WakefulIntentService;->sendWakefulWork(Landroid/content/Context;Ljava/lang/Class;)V

    .line 126
    :goto_50
    return-void

    .line 121
    :cond_51
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    iget v3, p0, Lorg/adaway/service/UpdateService;->mNumberOfDownloads:I

    iget v4, p0, Lorg/adaway/service/UpdateService;->mNumberOfFailedDownloads:I

    sub-int/2addr v3, v4

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "/"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget v3, p0, Lorg/adaway/service/UpdateService;->mNumberOfDownloads:I

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 124
    .local v1, "successfulDownloads":Ljava/lang/String;
    iget-object v2, p0, Lorg/adaway/service/UpdateService;->mService:Landroid/content/Context;

    invoke-static {v2, v0, v1}, Lorg/adaway/helper/ResultHelper;->showNotificationBasedOnResult(Landroid/content/Context;ILjava/lang/String;)V

    goto :goto_50
.end method

.method public onStartCommand(Landroid/content/Intent;II)I
    .registers 7
    .param p1, "intent"    # Landroid/content/Intent;
    .param p2, "flags"    # I
    .param p3, "startId"    # I

    .prologue
    const/4 v2, 0x0

    .line 74
    iput-object p0, p0, Lorg/adaway/service/UpdateService;->mService:Landroid/content/Context;

    .line 76
    const-string v1, "notification"

    invoke-virtual {p0, v1}, Lorg/adaway/service/UpdateService;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/app/NotificationManager;

    iput-object v1, p0, Lorg/adaway/service/UpdateService;->mNotificationManager:Landroid/app/NotificationManager;

    .line 79
    iput-boolean v2, p0, Lorg/adaway/service/UpdateService;->mBackgroundExecution:Z

    .line 80
    invoke-virtual {p1}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v0

    .line 81
    .local v0, "extras":Landroid/os/Bundle;
    if-eqz v0, :cond_25

    .line 82
    const-string v1, "org.adaway.BACKGROUND_EXECUTION"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_25

    .line 83
    const-string v1, "org.adaway.BACKGROUND_EXECUTION"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v1

    iput-boolean v1, p0, Lorg/adaway/service/UpdateService;->mBackgroundExecution:Z

    .line 88
    :cond_25
    iput-boolean v2, p0, Lorg/adaway/service/UpdateService;->mApplyAfterCheck:Z

    .line 89
    iget-boolean v1, p0, Lorg/adaway/service/UpdateService;->mBackgroundExecution:Z

    if-eqz v1, :cond_3b

    .line 90
    iget-object v1, p0, Lorg/adaway/service/UpdateService;->mService:Landroid/content/Context;

    invoke-static {v1}, Lorg/adaway/helper/PreferenceHelper;->getAutomaticUpdateDaily(Landroid/content/Context;)Z

    move-result v1

    if-eqz v1, :cond_3b

    .line 91
    const-string v1, "org.adaway.BACKGROUND_EXECUTION"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v1

    iput-boolean v1, p0, Lorg/adaway/service/UpdateService;->mApplyAfterCheck:Z

    .line 95
    :cond_3b
    invoke-super {p0, p1, p2, p3}, Lcom/commonsware/cwac/wakeful/WakefulIntentService;->onStartCommand(Landroid/content/Intent;II)I

    move-result v1

    return v1
.end method
