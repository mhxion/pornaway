.class public Lorg/pornaway/service/ApplyService;
.super Lcom/commonsware/cwac/wakeful/WakefulIntentService;
.source "ApplyService.java"


# static fields
.field private static final APPLY_NOTIFICATION_ID:I = 0x14


# instance fields
.field private mNotificationManager:Landroid/app/NotificationManager;

.field private mNumberOfDownloads:I

.field private mNumberOfFailedDownloads:I

.field private mService:Landroid/content/Context;


# direct methods
.method public constructor <init>()V
    .registers 2

    .prologue
    .line 75
    const-string v0, "PornAwayApplyService"

    invoke-direct {p0, v0}, Lcom/commonsware/cwac/wakeful/WakefulIntentService;-><init>(Ljava/lang/String;)V

    .line 76
    return-void
.end method

.method private cancelApplyNotification()V
    .registers 3

    .prologue
    .line 582
    iget-object v0, p0, Lorg/pornaway/service/ApplyService;->mNotificationManager:Landroid/app/NotificationManager;

    const/16 v1, 0x14

    invoke-virtual {v0, v1}, Landroid/app/NotificationManager;->cancel(I)V

    .line 583
    return-void
.end method

.method private download()I
    .registers 27

    .prologue
    .line 139
    const/16 v19, 0x1

    .line 141
    .local v19, "returnCode":I
    move-object/from16 v0, p0

    iget-object v0, v0, Lorg/pornaway/service/ApplyService;->mService:Landroid/content/Context;

    move-object/from16 v20, v0

    invoke-static/range {v20 .. v20}, Lorg/pornaway/util/Utils;->isAndroidOnline(Landroid/content/Context;)Z

    move-result v20

    if-eqz v20, :cond_27d

    .line 143
    move-object/from16 v0, p0

    iget-object v0, v0, Lorg/pornaway/service/ApplyService;->mService:Landroid/content/Context;

    move-object/from16 v20, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lorg/pornaway/service/ApplyService;->mService:Landroid/content/Context;

    move-object/from16 v21, v0

    const v22, 0x7f080032

    invoke-virtual/range {v21 .. v22}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v21

    move-object/from16 v0, p0

    iget-object v0, v0, Lorg/pornaway/service/ApplyService;->mService:Landroid/content/Context;

    move-object/from16 v22, v0

    const v23, 0x7f080032

    .line 144
    invoke-virtual/range {v22 .. v23}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v22

    move-object/from16 v0, p0

    iget-object v0, v0, Lorg/pornaway/service/ApplyService;->mService:Landroid/content/Context;

    move-object/from16 v23, v0

    const v24, 0x7f080032

    .line 145
    invoke-virtual/range {v23 .. v24}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v23

    .line 143
    move-object/from16 v0, p0

    move-object/from16 v1, v20

    move-object/from16 v2, v21

    move-object/from16 v3, v22

    move-object/from16 v4, v23

    invoke-direct {v0, v1, v2, v3, v4}, Lorg/pornaway/service/ApplyService;->showApplyNotification(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 148
    const/16 v18, 0x0

    .line 151
    .local v18, "out":Ljava/io/FileOutputStream;
    :try_start_4a
    move-object/from16 v0, p0

    iget-object v0, v0, Lorg/pornaway/service/ApplyService;->mService:Landroid/content/Context;

    move-object/from16 v20, v0

    const-string v21, "hosts_downloaded"

    const/16 v22, 0x0

    invoke-virtual/range {v20 .. v22}, Landroid/content/Context;->openFileOutput(Ljava/lang/String;I)Ljava/io/FileOutputStream;

    move-result-object v18

    .line 154
    const/16 v20, 0x0

    move/from16 v0, v20

    move-object/from16 v1, p0

    iput v0, v1, Lorg/pornaway/service/ApplyService;->mNumberOfFailedDownloads:I

    .line 155
    const/16 v20, 0x0

    move/from16 v0, v20

    move-object/from16 v1, p0

    iput v0, v1, Lorg/pornaway/service/ApplyService;->mNumberOfDownloads:I

    .line 158
    move-object/from16 v0, p0

    iget-object v0, v0, Lorg/pornaway/service/ApplyService;->mService:Landroid/content/Context;

    move-object/from16 v20, v0

    invoke-static/range {v20 .. v20}, Lorg/pornaway/provider/ProviderHelper;->getEnabledHostsSourcesCursor(Landroid/content/Context;)Landroid/database/Cursor;

    move-result-object v15

    .line 161
    .local v15, "enabledHostsSourcesCursor":Landroid/database/Cursor;
    invoke-interface {v15}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v20

    if-eqz v20, :cond_17f

    .line 164
    :cond_78
    move-object/from16 v0, p0

    iget v0, v0, Lorg/pornaway/service/ApplyService;->mNumberOfDownloads:I

    move/from16 v20, v0

    add-int/lit8 v20, v20, 0x1

    move/from16 v0, v20

    move-object/from16 v1, p0

    iput v0, v1, Lorg/pornaway/service/ApplyService;->mNumberOfDownloads:I

    .line 166
    const/16 v16, 0x0

    .line 167
    .local v16, "is":Ljava/io/InputStream;
    const/4 v6, 0x0

    .line 168
    .local v6, "bis":Ljava/io/BufferedInputStream;
    const-string v20, "url"

    .line 169
    move-object/from16 v0, v20

    invoke-interface {v15, v0}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v20

    move/from16 v0, v20

    invoke-interface {v15, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;
    :try_end_96
    .catch Ljava/lang/Exception; {:try_start_4a .. :try_end_96} :catch_20b
    .catchall {:try_start_4a .. :try_end_96} :catchall_24e

    move-result-object v12

    .line 172
    .local v12, "currentUrl":Ljava/lang/String;
    :try_start_97
    const-string v20, "PornAway"

    new-instance v21, Ljava/lang/StringBuilder;

    invoke-direct/range {v21 .. v21}, Ljava/lang/StringBuilder;-><init>()V

    const-string v22, "Downloading hosts file: "

    invoke-virtual/range {v21 .. v22}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v21

    move-object/from16 v0, v21

    invoke-virtual {v0, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v21

    invoke-virtual/range {v21 .. v21}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v21

    invoke-static/range {v20 .. v21}, Lorg/pornaway/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)V

    .line 175
    move-object/from16 v0, p0

    iget-object v0, v0, Lorg/pornaway/service/ApplyService;->mService:Landroid/content/Context;

    move-object/from16 v20, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lorg/pornaway/service/ApplyService;->mService:Landroid/content/Context;

    move-object/from16 v21, v0

    const v22, 0x7f080032

    .line 176
    invoke-virtual/range {v21 .. v22}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v21

    .line 175
    move-object/from16 v0, p0

    move-object/from16 v1, v20

    move-object/from16 v2, v21

    invoke-direct {v0, v1, v2, v12}, Lorg/pornaway/service/ApplyService;->updateApplyNotification(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    .line 179
    new-instance v17, Ljava/net/URL;

    move-object/from16 v0, v17

    invoke-direct {v0, v12}, Ljava/net/URL;-><init>(Ljava/lang/String;)V

    .line 180
    .local v17, "mURL":Ljava/net/URL;
    invoke-virtual/range {v17 .. v17}, Ljava/net/URL;->openConnection()Ljava/net/URLConnection;

    move-result-object v8

    .line 181
    .local v8, "connection":Ljava/net/URLConnection;
    const/16 v20, 0x3a98

    move/from16 v0, v20

    invoke-virtual {v8, v0}, Ljava/net/URLConnection;->setConnectTimeout(I)V

    .line 182
    const/16 v20, 0x7530

    move/from16 v0, v20

    invoke-virtual {v8, v0}, Ljava/net/URLConnection;->setReadTimeout(I)V

    .line 185
    invoke-virtual {v8}, Ljava/net/URLConnection;->connect()V

    .line 186
    invoke-virtual {v8}, Ljava/net/URLConnection;->getInputStream()Ljava/io/InputStream;

    move-result-object v16

    .line 188
    new-instance v7, Ljava/io/BufferedInputStream;

    move-object/from16 v0, v16

    invoke-direct {v7, v0}, Ljava/io/BufferedInputStream;-><init>(Ljava/io/InputStream;)V
    :try_end_f4
    .catch Ljava/io/IOException; {:try_start_97 .. :try_end_f4} :catch_284
    .catchall {:try_start_97 .. :try_end_f4} :catchall_23d

    .line 189
    .end local v6    # "bis":Ljava/io/BufferedInputStream;
    .local v7, "bis":Ljava/io/BufferedInputStream;
    if-nez v16, :cond_fd

    .line 190
    :try_start_f6
    const-string v20, "PornAway"

    const-string v21, "Stream is null"

    invoke-static/range {v20 .. v21}, Lorg/pornaway/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 194
    :cond_fd
    const/16 v20, 0x400

    move/from16 v0, v20

    new-array v13, v0, [B

    .line 195
    .local v13, "data":[B
    const/4 v9, 0x0

    .line 198
    .local v9, "count":I
    :goto_104
    invoke-virtual {v7, v13}, Ljava/io/BufferedInputStream;->read([B)I

    move-result v9

    const/16 v20, -0x1

    move/from16 v0, v20

    if-eq v9, v0, :cond_1ac

    .line 199
    const/16 v20, 0x0

    move-object/from16 v0, v18

    move/from16 v1, v20

    invoke-virtual {v0, v13, v1, v9}, Ljava/io/FileOutputStream;->write([BII)V
    :try_end_117
    .catch Ljava/io/IOException; {:try_start_f6 .. :try_end_117} :catch_118
    .catchall {:try_start_f6 .. :try_end_117} :catchall_281

    goto :goto_104

    .line 214
    .end local v9    # "count":I
    .end local v13    # "data":[B
    :catch_118
    move-exception v14

    move-object v6, v7

    .line 215
    .end local v7    # "bis":Ljava/io/BufferedInputStream;
    .end local v8    # "connection":Ljava/net/URLConnection;
    .end local v17    # "mURL":Ljava/net/URL;
    .restart local v6    # "bis":Ljava/io/BufferedInputStream;
    .local v14, "e":Ljava/io/IOException;
    :goto_11a
    :try_start_11a
    const-string v20, "PornAway"

    new-instance v21, Ljava/lang/StringBuilder;

    invoke-direct/range {v21 .. v21}, Ljava/lang/StringBuilder;-><init>()V

    const-string v22, "Exception while downloading from "

    invoke-virtual/range {v21 .. v22}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v21

    move-object/from16 v0, v21

    invoke-virtual {v0, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v21

    invoke-virtual/range {v21 .. v21}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v21

    move-object/from16 v0, v20

    move-object/from16 v1, v21

    invoke-static {v0, v1, v14}, Lorg/pornaway/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 218
    move-object/from16 v0, p0

    iget v0, v0, Lorg/pornaway/service/ApplyService;->mNumberOfFailedDownloads:I

    move/from16 v20, v0

    add-int/lit8 v20, v20, 0x1

    move/from16 v0, v20

    move-object/from16 v1, p0

    iput v0, v1, Lorg/pornaway/service/ApplyService;->mNumberOfFailedDownloads:I

    .line 221
    move-object/from16 v0, p0

    iget-object v0, v0, Lorg/pornaway/service/ApplyService;->mService:Landroid/content/Context;

    move-object/from16 v20, v0

    const-string v21, "_id"

    .line 223
    move-object/from16 v0, v21

    invoke-interface {v15, v0}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v21

    .line 222
    move/from16 v0, v21

    invoke-interface {v15, v0}, Landroid/database/Cursor;->getInt(I)I

    move-result v21

    move/from16 v0, v21

    int-to-long v0, v0

    move-wide/from16 v22, v0

    const-wide/16 v24, 0x0

    .line 221
    move-object/from16 v0, v20

    move-wide/from16 v1, v22

    move-wide/from16 v3, v24

    invoke-static {v0, v1, v2, v3, v4}, Lorg/pornaway/provider/ProviderHelper;->updateHostsSourceLastModifiedOnline(Landroid/content/Context;JJ)V
    :try_end_16a
    .catchall {:try_start_11a .. :try_end_16a} :catchall_23d

    .line 228
    if-eqz v18, :cond_16f

    .line 229
    :try_start_16c
    invoke-virtual/range {v18 .. v18}, Ljava/io/FileOutputStream;->flush()V

    .line 231
    :cond_16f
    if-eqz v6, :cond_174

    .line 232
    invoke-virtual {v6}, Ljava/io/BufferedInputStream;->close()V

    .line 234
    :cond_174
    if-eqz v16, :cond_179

    .line 235
    invoke-virtual/range {v16 .. v16}, Ljava/io/InputStream;->close()V
    :try_end_179
    .catch Ljava/lang/Exception; {:try_start_16c .. :try_end_179} :catch_1fd
    .catchall {:try_start_16c .. :try_end_179} :catchall_24e

    .line 242
    .end local v14    # "e":Ljava/io/IOException;
    :cond_179
    :goto_179
    :try_start_179
    invoke-interface {v15}, Landroid/database/Cursor;->moveToNext()Z

    move-result v20

    if-nez v20, :cond_78

    .line 246
    .end local v6    # "bis":Ljava/io/BufferedInputStream;
    .end local v12    # "currentUrl":Ljava/lang/String;
    .end local v16    # "is":Ljava/io/InputStream;
    :cond_17f
    if-eqz v15, :cond_18a

    invoke-interface {v15}, Landroid/database/Cursor;->isClosed()Z

    move-result v20

    if-nez v20, :cond_18a

    .line 247
    invoke-interface {v15}, Landroid/database/Cursor;->close()V

    .line 251
    :cond_18a
    move-object/from16 v0, p0

    iget v0, v0, Lorg/pornaway/service/ApplyService;->mNumberOfDownloads:I

    move/from16 v20, v0

    move-object/from16 v0, p0

    iget v0, v0, Lorg/pornaway/service/ApplyService;->mNumberOfFailedDownloads:I

    move/from16 v21, v0

    move/from16 v0, v20

    move/from16 v1, v21

    if-ne v0, v1, :cond_1a6

    move-object/from16 v0, p0

    iget v0, v0, Lorg/pornaway/service/ApplyService;->mNumberOfDownloads:I

    move/from16 v20, v0
    :try_end_1a2
    .catch Ljava/lang/Exception; {:try_start_179 .. :try_end_1a2} :catch_20b
    .catchall {:try_start_179 .. :try_end_1a2} :catchall_24e

    if-eqz v20, :cond_1a6

    .line 252
    const/16 v19, 0x6

    .line 259
    :cond_1a6
    if-eqz v18, :cond_1ab

    .line 260
    :try_start_1a8
    invoke-virtual/range {v18 .. v18}, Ljava/io/FileOutputStream;->close()V
    :try_end_1ab
    .catch Ljava/lang/Exception; {:try_start_1a8 .. :try_end_1ab} :catch_262

    .line 270
    .end local v15    # "enabledHostsSourcesCursor":Landroid/database/Cursor;
    .end local v18    # "out":Ljava/io/FileOutputStream;
    :cond_1ab
    :goto_1ab
    return v19

    .line 203
    .restart local v7    # "bis":Ljava/io/BufferedInputStream;
    .restart local v8    # "connection":Ljava/net/URLConnection;
    .restart local v9    # "count":I
    .restart local v12    # "currentUrl":Ljava/lang/String;
    .restart local v13    # "data":[B
    .restart local v15    # "enabledHostsSourcesCursor":Landroid/database/Cursor;
    .restart local v16    # "is":Ljava/io/InputStream;
    .restart local v17    # "mURL":Ljava/net/URL;
    .restart local v18    # "out":Ljava/io/FileOutputStream;
    :cond_1ac
    :try_start_1ac
    sget-object v20, Lorg/pornaway/util/Constants;->LINE_SEPERATOR:Ljava/lang/String;

    invoke-virtual/range {v20 .. v20}, Ljava/lang/String;->getBytes()[B

    move-result-object v20

    move-object/from16 v0, v18

    move-object/from16 v1, v20

    invoke-virtual {v0, v1}, Ljava/io/FileOutputStream;->write([B)V

    .line 206
    invoke-virtual {v8}, Ljava/net/URLConnection;->getLastModified()J

    move-result-wide v10

    .line 208
    .local v10, "currentLastModifiedOnline":J
    move-object/from16 v0, p0

    iget-object v0, v0, Lorg/pornaway/service/ApplyService;->mService:Landroid/content/Context;

    move-object/from16 v20, v0

    const-string v21, "_id"

    .line 210
    move-object/from16 v0, v21

    invoke-interface {v15, v0}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v21

    .line 209
    move/from16 v0, v21

    invoke-interface {v15, v0}, Landroid/database/Cursor;->getInt(I)I

    move-result v21

    move/from16 v0, v21

    int-to-long v0, v0

    move-wide/from16 v22, v0

    .line 208
    move-object/from16 v0, v20

    move-wide/from16 v1, v22

    invoke-static {v0, v1, v2, v10, v11}, Lorg/pornaway/provider/ProviderHelper;->updateHostsSourceLastModifiedOnline(Landroid/content/Context;JJ)V
    :try_end_1dd
    .catch Ljava/io/IOException; {:try_start_1ac .. :try_end_1dd} :catch_118
    .catchall {:try_start_1ac .. :try_end_1dd} :catchall_281

    .line 228
    if-eqz v18, :cond_1e2

    .line 229
    :try_start_1df
    invoke-virtual/range {v18 .. v18}, Ljava/io/FileOutputStream;->flush()V

    .line 231
    :cond_1e2
    if-eqz v7, :cond_1e7

    .line 232
    invoke-virtual {v7}, Ljava/io/BufferedInputStream;->close()V

    .line 234
    :cond_1e7
    if-eqz v16, :cond_1ec

    .line 235
    invoke-virtual/range {v16 .. v16}, Ljava/io/InputStream;->close()V
    :try_end_1ec
    .catch Ljava/lang/Exception; {:try_start_1df .. :try_end_1ec} :catch_1ee
    .catchall {:try_start_1df .. :try_end_1ec} :catchall_24e

    :cond_1ec
    move-object v6, v7

    .line 239
    .end local v7    # "bis":Ljava/io/BufferedInputStream;
    .restart local v6    # "bis":Ljava/io/BufferedInputStream;
    goto :goto_179

    .line 237
    .end local v6    # "bis":Ljava/io/BufferedInputStream;
    .restart local v7    # "bis":Ljava/io/BufferedInputStream;
    :catch_1ee
    move-exception v14

    .line 238
    .local v14, "e":Ljava/lang/Exception;
    :try_start_1ef
    const-string v20, "PornAway"

    const-string v21, "Exception on flush and closing streams."

    move-object/from16 v0, v20

    move-object/from16 v1, v21

    invoke-static {v0, v1, v14}, Lorg/pornaway/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    move-object v6, v7

    .line 240
    .end local v7    # "bis":Ljava/io/BufferedInputStream;
    .restart local v6    # "bis":Ljava/io/BufferedInputStream;
    goto/16 :goto_179

    .line 237
    .end local v8    # "connection":Ljava/net/URLConnection;
    .end local v9    # "count":I
    .end local v10    # "currentLastModifiedOnline":J
    .end local v13    # "data":[B
    .end local v17    # "mURL":Ljava/net/URL;
    .local v14, "e":Ljava/io/IOException;
    :catch_1fd
    move-exception v14

    .line 238
    .local v14, "e":Ljava/lang/Exception;
    const-string v20, "PornAway"

    const-string v21, "Exception on flush and closing streams."

    move-object/from16 v0, v20

    move-object/from16 v1, v21

    invoke-static {v0, v1, v14}, Lorg/pornaway/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    :try_end_209
    .catch Ljava/lang/Exception; {:try_start_1ef .. :try_end_209} :catch_20b
    .catchall {:try_start_1ef .. :try_end_209} :catchall_24e

    goto/16 :goto_179

    .line 254
    .end local v6    # "bis":Ljava/io/BufferedInputStream;
    .end local v12    # "currentUrl":Ljava/lang/String;
    .end local v14    # "e":Ljava/lang/Exception;
    .end local v15    # "enabledHostsSourcesCursor":Landroid/database/Cursor;
    .end local v16    # "is":Ljava/io/InputStream;
    :catch_20b
    move-exception v14

    .line 255
    .restart local v14    # "e":Ljava/lang/Exception;
    :try_start_20c
    const-string v20, "PornAway"

    new-instance v21, Ljava/lang/StringBuilder;

    invoke-direct/range {v21 .. v21}, Ljava/lang/StringBuilder;-><init>()V

    const-string v22, "Private File can not be created, Exception: "

    invoke-virtual/range {v21 .. v22}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v21

    move-object/from16 v0, v21

    invoke-virtual {v0, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v21

    invoke-virtual/range {v21 .. v21}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v21

    invoke-static/range {v20 .. v21}, Lorg/pornaway/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_226
    .catchall {:try_start_20c .. :try_end_226} :catchall_24e

    .line 256
    const/16 v19, 0x2

    .line 259
    if-eqz v18, :cond_1ab

    .line 260
    :try_start_22a
    invoke-virtual/range {v18 .. v18}, Ljava/io/FileOutputStream;->close()V
    :try_end_22d
    .catch Ljava/lang/Exception; {:try_start_22a .. :try_end_22d} :catch_22f

    goto/16 :goto_1ab

    .line 262
    :catch_22f
    move-exception v14

    .line 263
    const-string v20, "PornAway"

    const-string v21, "Exception on close of out."

    move-object/from16 v0, v20

    move-object/from16 v1, v21

    invoke-static {v0, v1, v14}, Lorg/pornaway/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto/16 :goto_1ab

    .line 227
    .end local v14    # "e":Ljava/lang/Exception;
    .restart local v6    # "bis":Ljava/io/BufferedInputStream;
    .restart local v12    # "currentUrl":Ljava/lang/String;
    .restart local v15    # "enabledHostsSourcesCursor":Landroid/database/Cursor;
    .restart local v16    # "is":Ljava/io/InputStream;
    :catchall_23d
    move-exception v20

    .line 228
    :goto_23e
    if-eqz v18, :cond_243

    .line 229
    :try_start_240
    invoke-virtual/range {v18 .. v18}, Ljava/io/FileOutputStream;->flush()V

    .line 231
    :cond_243
    if-eqz v6, :cond_248

    .line 232
    invoke-virtual {v6}, Ljava/io/BufferedInputStream;->close()V

    .line 234
    :cond_248
    if-eqz v16, :cond_24d

    .line 235
    invoke-virtual/range {v16 .. v16}, Ljava/io/InputStream;->close()V
    :try_end_24d
    .catch Ljava/lang/Exception; {:try_start_240 .. :try_end_24d} :catch_255
    .catchall {:try_start_240 .. :try_end_24d} :catchall_24e

    .line 239
    :cond_24d
    :goto_24d
    :try_start_24d
    throw v20
    :try_end_24e
    .catch Ljava/lang/Exception; {:try_start_24d .. :try_end_24e} :catch_20b
    .catchall {:try_start_24d .. :try_end_24e} :catchall_24e

    .line 258
    .end local v6    # "bis":Ljava/io/BufferedInputStream;
    .end local v12    # "currentUrl":Ljava/lang/String;
    .end local v15    # "enabledHostsSourcesCursor":Landroid/database/Cursor;
    .end local v16    # "is":Ljava/io/InputStream;
    :catchall_24e
    move-exception v20

    .line 259
    if-eqz v18, :cond_254

    .line 260
    :try_start_251
    invoke-virtual/range {v18 .. v18}, Ljava/io/FileOutputStream;->close()V
    :try_end_254
    .catch Ljava/lang/Exception; {:try_start_251 .. :try_end_254} :catch_270

    .line 264
    :cond_254
    :goto_254
    throw v20

    .line 237
    .restart local v6    # "bis":Ljava/io/BufferedInputStream;
    .restart local v12    # "currentUrl":Ljava/lang/String;
    .restart local v15    # "enabledHostsSourcesCursor":Landroid/database/Cursor;
    .restart local v16    # "is":Ljava/io/InputStream;
    :catch_255
    move-exception v14

    .line 238
    .restart local v14    # "e":Ljava/lang/Exception;
    :try_start_256
    const-string v21, "PornAway"

    const-string v22, "Exception on flush and closing streams."

    move-object/from16 v0, v21

    move-object/from16 v1, v22

    invoke-static {v0, v1, v14}, Lorg/pornaway/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    :try_end_261
    .catch Ljava/lang/Exception; {:try_start_256 .. :try_end_261} :catch_20b
    .catchall {:try_start_256 .. :try_end_261} :catchall_24e

    goto :goto_24d

    .line 262
    .end local v6    # "bis":Ljava/io/BufferedInputStream;
    .end local v12    # "currentUrl":Ljava/lang/String;
    .end local v14    # "e":Ljava/lang/Exception;
    .end local v16    # "is":Ljava/io/InputStream;
    :catch_262
    move-exception v14

    .line 263
    .restart local v14    # "e":Ljava/lang/Exception;
    const-string v20, "PornAway"

    const-string v21, "Exception on close of out."

    move-object/from16 v0, v20

    move-object/from16 v1, v21

    invoke-static {v0, v1, v14}, Lorg/pornaway/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto/16 :goto_1ab

    .line 262
    .end local v14    # "e":Ljava/lang/Exception;
    .end local v15    # "enabledHostsSourcesCursor":Landroid/database/Cursor;
    :catch_270
    move-exception v14

    .line 263
    .restart local v14    # "e":Ljava/lang/Exception;
    const-string v21, "PornAway"

    const-string v22, "Exception on close of out."

    move-object/from16 v0, v21

    move-object/from16 v1, v22

    invoke-static {v0, v1, v14}, Lorg/pornaway/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_254

    .line 267
    .end local v14    # "e":Ljava/lang/Exception;
    .end local v18    # "out":Ljava/io/FileOutputStream;
    :cond_27d
    const/16 v19, 0x7

    goto/16 :goto_1ab

    .line 227
    .restart local v7    # "bis":Ljava/io/BufferedInputStream;
    .restart local v8    # "connection":Ljava/net/URLConnection;
    .restart local v12    # "currentUrl":Ljava/lang/String;
    .restart local v15    # "enabledHostsSourcesCursor":Landroid/database/Cursor;
    .restart local v16    # "is":Ljava/io/InputStream;
    .restart local v17    # "mURL":Ljava/net/URL;
    .restart local v18    # "out":Ljava/io/FileOutputStream;
    :catchall_281
    move-exception v20

    move-object v6, v7

    .end local v7    # "bis":Ljava/io/BufferedInputStream;
    .restart local v6    # "bis":Ljava/io/BufferedInputStream;
    goto :goto_23e

    .line 214
    .end local v8    # "connection":Ljava/net/URLConnection;
    .end local v17    # "mURL":Ljava/net/URL;
    :catch_284
    move-exception v14

    goto/16 :goto_11a
.end method

.method private showApplyNotification(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .registers 15
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "tickerText"    # Ljava/lang/String;
    .param p3, "contentTitle"    # Ljava/lang/String;
    .param p4, "contentText"    # Ljava/lang/String;

    .prologue
    .line 532
    new-instance v3, Landroid/content/Intent;

    iget-object v5, p0, Lorg/pornaway/service/ApplyService;->mService:Landroid/content/Context;

    const-class v8, Lorg/pornaway/ui/BaseActivity;

    invoke-direct {v3, v5, v8}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 533
    .local v3, "intent":Landroid/content/Intent;
    iget-object v5, p0, Lorg/pornaway/service/ApplyService;->mService:Landroid/content/Context;

    invoke-virtual {v5}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v5

    const/4 v8, 0x0

    const/high16 v9, 0x10000000

    invoke-static {v5, v8, v3, v9}, Landroid/app/PendingIntent;->getActivity(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;

    move-result-object v0

    .line 537
    .local v0, "contentIntent":Landroid/app/PendingIntent;
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v8, p0, Lorg/pornaway/service/ApplyService;->mService:Landroid/content/Context;

    const/high16 v9, 0x7f080000

    invoke-virtual {v8, v9}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v5, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v8, ": "

    invoke-virtual {v5, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p2

    .line 538
    const v2, 0x7f020085

    .line 539
    .local v2, "icon":I
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v6

    .line 542
    .local v6, "when":J
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v8, p0, Lorg/pornaway/service/ApplyService;->mService:Landroid/content/Context;

    const/high16 v9, 0x7f080000

    invoke-virtual {v8, v9}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v5, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v8, ": "

    invoke-virtual {v5, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 545
    .local v1, "contentTitleWithAppName":Ljava/lang/String;
    new-instance v5, Landroid/support/v4/app/NotificationCompat$Builder;

    invoke-direct {v5, p1}, Landroid/support/v4/app/NotificationCompat$Builder;-><init>(Landroid/content/Context;)V

    .line 546
    invoke-virtual {v5, v2}, Landroid/support/v4/app/NotificationCompat$Builder;->setSmallIcon(I)Landroid/support/v4/app/NotificationCompat$Builder;

    move-result-object v5

    invoke-virtual {v5, v1}, Landroid/support/v4/app/NotificationCompat$Builder;->setContentTitle(Ljava/lang/CharSequence;)Landroid/support/v4/app/NotificationCompat$Builder;

    move-result-object v5

    invoke-virtual {v5, p2}, Landroid/support/v4/app/NotificationCompat$Builder;->setTicker(Ljava/lang/CharSequence;)Landroid/support/v4/app/NotificationCompat$Builder;

    move-result-object v5

    .line 547
    invoke-virtual {v5, v6, v7}, Landroid/support/v4/app/NotificationCompat$Builder;->setWhen(J)Landroid/support/v4/app/NotificationCompat$Builder;

    move-result-object v5

    const/4 v8, 0x1

    invoke-virtual {v5, v8}, Landroid/support/v4/app/NotificationCompat$Builder;->setOngoing(Z)Landroid/support/v4/app/NotificationCompat$Builder;

    move-result-object v5

    const/4 v8, 0x1

    invoke-virtual {v5, v8}, Landroid/support/v4/app/NotificationCompat$Builder;->setOnlyAlertOnce(Z)Landroid/support/v4/app/NotificationCompat$Builder;

    move-result-object v5

    invoke-virtual {v5, p4}, Landroid/support/v4/app/NotificationCompat$Builder;->setContentText(Ljava/lang/CharSequence;)Landroid/support/v4/app/NotificationCompat$Builder;

    move-result-object v4

    .line 549
    .local v4, "mBuilder":Landroid/support/v4/app/NotificationCompat$Builder;
    iget-object v5, p0, Lorg/pornaway/service/ApplyService;->mNotificationManager:Landroid/app/NotificationManager;

    const/16 v8, 0x14

    invoke-virtual {v4}, Landroid/support/v4/app/NotificationCompat$Builder;->build()Landroid/app/Notification;

    move-result-object v9

    invoke-virtual {v5, v8, v9}, Landroid/app/NotificationManager;->notify(ILandroid/app/Notification;)V

    .line 551
    invoke-virtual {v4, v0}, Landroid/support/v4/app/NotificationCompat$Builder;->setContentIntent(Landroid/app/PendingIntent;)Landroid/support/v4/app/NotificationCompat$Builder;

    .line 554
    iget-object v5, p0, Lorg/pornaway/service/ApplyService;->mService:Landroid/content/Context;

    const/4 v8, 0x0

    invoke-static {v5, p3, p4, v8}, Lorg/pornaway/ui/BaseActivity;->setStatusBroadcast(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;I)V

    .line 555
    return-void
.end method

.method private updateApplyNotification(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    .registers 13
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "contentTitle"    # Ljava/lang/String;
    .param p3, "contentText"    # Ljava/lang/String;

    .prologue
    const/4 v8, 0x0

    .line 559
    new-instance v3, Landroid/content/Intent;

    iget-object v5, p0, Lorg/pornaway/service/ApplyService;->mService:Landroid/content/Context;

    const-class v6, Lorg/pornaway/ui/BaseActivity;

    invoke-direct {v3, v5, v6}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 560
    .local v3, "intent":Landroid/content/Intent;
    iget-object v5, p0, Lorg/pornaway/service/ApplyService;->mService:Landroid/content/Context;

    invoke-virtual {v5}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v5

    const/high16 v6, 0x10000000

    invoke-static {v5, v8, v3, v6}, Landroid/app/PendingIntent;->getActivity(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;

    move-result-object v0

    .line 563
    .local v0, "contentIntent":Landroid/app/PendingIntent;
    const v2, 0x7f020085

    .line 566
    .local v2, "icon":I
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v6, p0, Lorg/pornaway/service/ApplyService;->mService:Landroid/content/Context;

    const/high16 v7, 0x7f080000

    invoke-virtual {v6, v7}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, ": "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 569
    .local v1, "contentTitleWithAppName":Ljava/lang/String;
    new-instance v5, Landroid/support/v4/app/NotificationCompat$Builder;

    invoke-direct {v5, p1}, Landroid/support/v4/app/NotificationCompat$Builder;-><init>(Landroid/content/Context;)V

    .line 570
    invoke-virtual {v5, v2}, Landroid/support/v4/app/NotificationCompat$Builder;->setSmallIcon(I)Landroid/support/v4/app/NotificationCompat$Builder;

    move-result-object v5

    invoke-virtual {v5, v1}, Landroid/support/v4/app/NotificationCompat$Builder;->setContentTitle(Ljava/lang/CharSequence;)Landroid/support/v4/app/NotificationCompat$Builder;

    move-result-object v5

    .line 571
    invoke-virtual {v5, p3}, Landroid/support/v4/app/NotificationCompat$Builder;->setContentText(Ljava/lang/CharSequence;)Landroid/support/v4/app/NotificationCompat$Builder;

    move-result-object v4

    .line 573
    .local v4, "mBuilder":Landroid/support/v4/app/NotificationCompat$Builder;
    iget-object v5, p0, Lorg/pornaway/service/ApplyService;->mNotificationManager:Landroid/app/NotificationManager;

    const/16 v6, 0x14

    invoke-virtual {v4}, Landroid/support/v4/app/NotificationCompat$Builder;->build()Landroid/app/Notification;

    move-result-object v7

    invoke-virtual {v5, v6, v7}, Landroid/app/NotificationManager;->notify(ILandroid/app/Notification;)V

    .line 575
    invoke-virtual {v4, v0}, Landroid/support/v4/app/NotificationCompat$Builder;->setContentIntent(Landroid/app/PendingIntent;)Landroid/support/v4/app/NotificationCompat$Builder;

    .line 578
    iget-object v5, p0, Lorg/pornaway/service/ApplyService;->mService:Landroid/content/Context;

    invoke-static {v5, p2, p3, v8}, Lorg/pornaway/ui/BaseActivity;->setStatusBroadcast(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;I)V

    .line 579
    return-void
.end method


# virtual methods
.method apply()I
    .registers 35

    .prologue
    .line 279
    move-object/from16 v0, p0

    iget-object v0, v0, Lorg/pornaway/service/ApplyService;->mService:Landroid/content/Context;

    move-object/from16 v29, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lorg/pornaway/service/ApplyService;->mService:Landroid/content/Context;

    move-object/from16 v30, v0

    const v31, 0x7f080005

    invoke-virtual/range {v30 .. v31}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v30

    move-object/from16 v0, p0

    iget-object v0, v0, Lorg/pornaway/service/ApplyService;->mService:Landroid/content/Context;

    move-object/from16 v31, v0

    const v32, 0x7f080005

    .line 280
    invoke-virtual/range {v31 .. v32}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v31

    move-object/from16 v0, p0

    iget-object v0, v0, Lorg/pornaway/service/ApplyService;->mService:Landroid/content/Context;

    move-object/from16 v32, v0

    const v33, 0x7f080007

    .line 281
    invoke-virtual/range {v32 .. v33}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v32

    .line 279
    move-object/from16 v0, p0

    move-object/from16 v1, v29

    move-object/from16 v2, v30

    move-object/from16 v3, v31

    move-object/from16 v4, v32

    invoke-direct {v0, v1, v2, v3, v4}, Lorg/pornaway/service/ApplyService;->showApplyNotification(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 283
    const/16 v26, 0x1

    .line 284
    .local v26, "returnCode":I
    const/4 v5, 0x0

    .line 289
    .local v5, "bos":Ljava/io/BufferedOutputStream;
    :try_start_3d
    move-object/from16 v0, p0

    iget-object v0, v0, Lorg/pornaway/service/ApplyService;->mService:Landroid/content/Context;

    move-object/from16 v29, v0

    const-string v30, "hosts_downloaded"

    invoke-virtual/range {v29 .. v30}, Landroid/content/Context;->openFileInput(Ljava/lang/String;)Ljava/io/FileInputStream;

    move-result-object v10

    .line 291
    .local v10, "fis":Ljava/io/FileInputStream;
    new-instance v22, Ljava/io/BufferedReader;

    new-instance v29, Ljava/io/InputStreamReader;

    move-object/from16 v0, v29

    invoke-direct {v0, v10}, Ljava/io/InputStreamReader;-><init>(Ljava/io/InputStream;)V

    move-object/from16 v0, v22

    move-object/from16 v1, v29

    invoke-direct {v0, v1}, Ljava/io/BufferedReader;-><init>(Ljava/io/Reader;)V

    .line 294
    .local v22, "reader":Ljava/io/BufferedReader;
    new-instance v21, Lorg/pornaway/util/HostsParser;

    move-object/from16 v0, p0

    iget-object v0, v0, Lorg/pornaway/service/ApplyService;->mService:Landroid/content/Context;

    move-object/from16 v29, v0

    invoke-static/range {v29 .. v29}, Lorg/pornaway/helper/PreferenceHelper;->getWhitelistRules(Landroid/content/Context;)Z

    move-result v29

    move-object/from16 v0, p0

    iget-object v0, v0, Lorg/pornaway/service/ApplyService;->mService:Landroid/content/Context;

    move-object/from16 v30, v0

    invoke-static/range {v30 .. v30}, Lorg/pornaway/helper/PreferenceHelper;->getRedirectionRules(Landroid/content/Context;)Z

    move-result v30

    move-object/from16 v0, v21

    move-object/from16 v1, v22

    move/from16 v2, v29

    move/from16 v3, v30

    invoke-direct {v0, v1, v2, v3}, Lorg/pornaway/util/HostsParser;-><init>(Ljava/io/BufferedReader;ZZ)V

    .line 296
    .local v21, "parser":Lorg/pornaway/util/HostsParser;
    invoke-virtual {v10}, Ljava/io/FileInputStream;->close()V

    .line 298
    move-object/from16 v0, p0

    iget-object v0, v0, Lorg/pornaway/service/ApplyService;->mService:Landroid/content/Context;

    move-object/from16 v29, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lorg/pornaway/service/ApplyService;->mService:Landroid/content/Context;

    move-object/from16 v30, v0

    const v31, 0x7f080005

    invoke-virtual/range {v30 .. v31}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v30

    move-object/from16 v0, p0

    iget-object v0, v0, Lorg/pornaway/service/ApplyService;->mService:Landroid/content/Context;

    move-object/from16 v31, v0

    const v32, 0x7f080009

    .line 299
    invoke-virtual/range {v31 .. v32}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v31

    .line 298
    move-object/from16 v0, p0

    move-object/from16 v1, v29

    move-object/from16 v2, v30

    move-object/from16 v3, v31

    invoke-direct {v0, v1, v2, v3}, Lorg/pornaway/service/ApplyService;->updateApplyNotification(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    .line 304
    move-object/from16 v0, p0

    iget-object v0, v0, Lorg/pornaway/service/ApplyService;->mService:Landroid/content/Context;

    move-object/from16 v29, v0

    invoke-static/range {v29 .. v29}, Lorg/pornaway/provider/ProviderHelper;->getEnabledWhitelistHashSet(Landroid/content/Context;)Lgnu/trove/set/hash/THashSet;

    move-result-object v29

    move-object/from16 v0, v21

    move-object/from16 v1, v29

    invoke-virtual {v0, v1}, Lorg/pornaway/util/HostsParser;->addWhitelist(Lgnu/trove/set/hash/THashSet;)V

    .line 306
    move-object/from16 v0, p0

    iget-object v0, v0, Lorg/pornaway/service/ApplyService;->mService:Landroid/content/Context;

    move-object/from16 v29, v0

    invoke-static/range {v29 .. v29}, Lorg/pornaway/provider/ProviderHelper;->getEnabledBlacklistHashSet(Landroid/content/Context;)Lgnu/trove/set/hash/THashSet;

    move-result-object v29

    move-object/from16 v0, v21

    move-object/from16 v1, v29

    invoke-virtual {v0, v1}, Lorg/pornaway/util/HostsParser;->addBlacklist(Lgnu/trove/set/hash/THashSet;)V

    .line 308
    move-object/from16 v0, p0

    iget-object v0, v0, Lorg/pornaway/service/ApplyService;->mService:Landroid/content/Context;

    move-object/from16 v29, v0

    invoke-static/range {v29 .. v29}, Lorg/pornaway/provider/ProviderHelper;->getEnabledRedirectionListHashMap(Landroid/content/Context;)Lgnu/trove/map/hash/THashMap;

    move-result-object v29

    move-object/from16 v0, v21

    move-object/from16 v1, v29

    invoke-virtual {v0, v1}, Lorg/pornaway/util/HostsParser;->addRedirectionList(Lgnu/trove/map/hash/THashMap;)V

    .line 311
    move-object/from16 v0, p0

    iget-object v0, v0, Lorg/pornaway/service/ApplyService;->mService:Landroid/content/Context;

    move-object/from16 v29, v0

    .line 312
    invoke-static/range {v29 .. v29}, Lorg/pornaway/provider/ProviderHelper;->getEnabledHostsSourcesArrayList(Landroid/content/Context;)Ljava/util/ArrayList;

    move-result-object v9

    .line 313
    .local v9, "enabledHostsSources":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    const-string v29, "PornAway"

    new-instance v30, Ljava/lang/StringBuilder;

    invoke-direct/range {v30 .. v30}, Ljava/lang/StringBuilder;-><init>()V

    const-string v31, "Enabled hosts sources list: "

    invoke-virtual/range {v30 .. v31}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v30

    invoke-virtual {v9}, Ljava/util/ArrayList;->toString()Ljava/lang/String;

    move-result-object v31

    invoke-virtual/range {v30 .. v31}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v30

    invoke-virtual/range {v30 .. v30}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v30

    invoke-static/range {v29 .. v30}, Lorg/pornaway/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 316
    invoke-virtual/range {v21 .. v21}, Lorg/pornaway/util/HostsParser;->compileList()V

    .line 319
    move-object/from16 v0, p0

    iget-object v0, v0, Lorg/pornaway/service/ApplyService;->mService:Landroid/content/Context;

    move-object/from16 v29, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lorg/pornaway/service/ApplyService;->mService:Landroid/content/Context;

    move-object/from16 v30, v0

    const v31, 0x7f080005

    invoke-virtual/range {v30 .. v31}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v30

    move-object/from16 v0, p0

    iget-object v0, v0, Lorg/pornaway/service/ApplyService;->mService:Landroid/content/Context;

    move-object/from16 v31, v0

    const v32, 0x7f080008

    .line 320
    invoke-virtual/range {v31 .. v32}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v31

    .line 319
    move-object/from16 v0, p0

    move-object/from16 v1, v29

    move-object/from16 v2, v30

    move-object/from16 v3, v31

    invoke-direct {v0, v1, v2, v3}, Lorg/pornaway/service/ApplyService;->updateApplyNotification(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    .line 322
    move-object/from16 v0, p0

    iget-object v0, v0, Lorg/pornaway/service/ApplyService;->mService:Landroid/content/Context;

    move-object/from16 v29, v0

    const-string v30, "hosts"

    const/16 v31, 0x0

    invoke-virtual/range {v29 .. v31}, Landroid/content/Context;->openFileOutput(Ljava/lang/String;I)Ljava/io/FileOutputStream;

    move-result-object v12

    .line 325
    .local v12, "fos":Ljava/io/FileOutputStream;
    new-instance v6, Ljava/io/BufferedOutputStream;

    invoke-direct {v6, v12}, Ljava/io/BufferedOutputStream;-><init>(Ljava/io/OutputStream;)V
    :try_end_142
    .catch Ljava/io/FileNotFoundException; {:try_start_3d .. :try_end_142} :catch_5cd
    .catch Ljava/io/IOException; {:try_start_3d .. :try_end_142} :catch_5ca
    .catchall {:try_start_3d .. :try_end_142} :catchall_5c7

    .line 328
    .end local v5    # "bos":Ljava/io/BufferedOutputStream;
    .local v6, "bos":Ljava/io/BufferedOutputStream;
    :try_start_142
    new-instance v11, Ljava/text/SimpleDateFormat;

    const-string v29, "yyyy-MM-dd HH:mm:ss"

    move-object/from16 v0, v29

    invoke-direct {v11, v0}, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String;)V

    .line 329
    .local v11, "formatter":Ljava/text/SimpleDateFormat;
    new-instance v20, Ljava/util/Date;

    invoke-direct/range {v20 .. v20}, Ljava/util/Date;-><init>()V

    .line 332
    .local v20, "now":Ljava/util/Date;
    new-instance v29, Ljava/lang/StringBuilder;

    invoke-direct/range {v29 .. v29}, Ljava/lang/StringBuilder;-><init>()V

    const-string v30, "# This hosts file has been generated by PornAway on:"

    invoke-virtual/range {v29 .. v30}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v29

    sget-object v30, Lorg/pornaway/util/Constants;->LINE_SEPERATOR:Ljava/lang/String;

    invoke-virtual/range {v29 .. v30}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v29

    const-string v30, "# "

    invoke-virtual/range {v29 .. v30}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v29

    .line 333
    move-object/from16 v0, v20

    invoke-virtual {v11, v0}, Ljava/text/SimpleDateFormat;->format(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v30

    invoke-virtual/range {v29 .. v30}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v29

    sget-object v30, Lorg/pornaway/util/Constants;->LINE_SEPERATOR:Ljava/lang/String;

    invoke-virtual/range {v29 .. v30}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v29

    const-string v30, "# Please do not modify it directly, it will be overwritten when PornAway is applied again."

    invoke-virtual/range {v29 .. v30}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v29

    sget-object v30, Lorg/pornaway/util/Constants;->LINE_SEPERATOR:Ljava/lang/String;

    invoke-virtual/range {v29 .. v30}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v29

    const-string v30, "# This file is generated from the following sources:"

    invoke-virtual/range {v29 .. v30}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v29

    invoke-virtual/range {v29 .. v29}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v13

    .line 335
    .local v13, "header":Ljava/lang/String;
    invoke-virtual {v13}, Ljava/lang/String;->getBytes()[B

    move-result-object v29

    move-object/from16 v0, v29

    invoke-virtual {v6, v0}, Ljava/io/BufferedOutputStream;->write([B)V

    .line 338
    const/16 v28, 0x0

    .line 339
    .local v28, "source":Ljava/lang/String;
    invoke-virtual {v9}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v29

    :goto_19c
    invoke-interface/range {v29 .. v29}, Ljava/util/Iterator;->hasNext()Z

    move-result v30

    if-eqz v30, :cond_29c

    invoke-interface/range {v29 .. v29}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v14

    check-cast v14, Ljava/lang/String;

    .line 340
    .local v14, "host":Ljava/lang/String;
    new-instance v30, Ljava/lang/StringBuilder;

    invoke-direct/range {v30 .. v30}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v31, Lorg/pornaway/util/Constants;->LINE_SEPERATOR:Ljava/lang/String;

    invoke-virtual/range {v30 .. v31}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v30

    const-string v31, "# "

    invoke-virtual/range {v30 .. v31}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v30

    move-object/from16 v0, v30

    invoke-virtual {v0, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v30

    invoke-virtual/range {v30 .. v30}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v28

    .line 341
    invoke-virtual/range {v28 .. v28}, Ljava/lang/String;->getBytes()[B

    move-result-object v30

    move-object/from16 v0, v30

    invoke-virtual {v6, v0}, Ljava/io/BufferedOutputStream;->write([B)V
    :try_end_1cc
    .catch Ljava/io/FileNotFoundException; {:try_start_142 .. :try_end_1cc} :catch_1cd
    .catch Ljava/io/IOException; {:try_start_142 .. :try_end_1cc} :catch_36f
    .catchall {:try_start_142 .. :try_end_1cc} :catchall_3d7

    goto :goto_19c

    .line 388
    .end local v11    # "formatter":Ljava/text/SimpleDateFormat;
    .end local v13    # "header":Ljava/lang/String;
    .end local v14    # "host":Ljava/lang/String;
    .end local v20    # "now":Ljava/util/Date;
    .end local v28    # "source":Ljava/lang/String;
    :catch_1cd
    move-exception v8

    move-object v5, v6

    .line 389
    .end local v6    # "bos":Ljava/io/BufferedOutputStream;
    .end local v9    # "enabledHostsSources":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    .end local v10    # "fis":Ljava/io/FileInputStream;
    .end local v12    # "fos":Ljava/io/FileOutputStream;
    .end local v21    # "parser":Lorg/pornaway/util/HostsParser;
    .end local v22    # "reader":Ljava/io/BufferedReader;
    .restart local v5    # "bos":Ljava/io/BufferedOutputStream;
    .local v8, "e":Ljava/io/FileNotFoundException;
    :goto_1cf
    :try_start_1cf
    const-string v29, "PornAway"

    const-string v30, "file to read or file to write could not be found"

    move-object/from16 v0, v29

    move-object/from16 v1, v30

    invoke-static {v0, v1, v8}, Lorg/pornaway/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    :try_end_1da
    .catchall {:try_start_1cf .. :try_end_1da} :catchall_5c7

    .line 391
    const/16 v26, 0x2

    .line 399
    if-eqz v5, :cond_1e4

    .line 400
    :try_start_1de
    invoke-virtual {v5}, Ljava/io/BufferedOutputStream;->flush()V

    .line 401
    invoke-virtual {v5}, Ljava/io/BufferedOutputStream;->close()V
    :try_end_1e4
    .catch Ljava/lang/Exception; {:try_start_1de .. :try_end_1e4} :catch_45a

    .line 410
    .end local v8    # "e":Ljava/io/FileNotFoundException;
    :cond_1e4
    :goto_1e4
    move-object/from16 v0, p0

    iget-object v0, v0, Lorg/pornaway/service/ApplyService;->mService:Landroid/content/Context;

    move-object/from16 v29, v0

    const-string v30, "hosts_downloaded"

    invoke-virtual/range {v29 .. v30}, Landroid/content/Context;->deleteFile(Ljava/lang/String;)Z

    .line 413
    move-object/from16 v0, p0

    iget-object v0, v0, Lorg/pornaway/service/ApplyService;->mService:Landroid/content/Context;

    move-object/from16 v29, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lorg/pornaway/service/ApplyService;->mService:Landroid/content/Context;

    move-object/from16 v30, v0

    const v31, 0x7f080005

    invoke-virtual/range {v30 .. v31}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v30

    move-object/from16 v0, p0

    iget-object v0, v0, Lorg/pornaway/service/ApplyService;->mService:Landroid/content/Context;

    move-object/from16 v31, v0

    const v32, 0x7f080006

    .line 414
    invoke-virtual/range {v31 .. v32}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v31

    .line 413
    move-object/from16 v0, p0

    move-object/from16 v1, v29

    move-object/from16 v2, v30

    move-object/from16 v3, v31

    invoke-direct {v0, v1, v2, v3}, Lorg/pornaway/service/ApplyService;->updateApplyNotification(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    .line 416
    const/16 v27, 0x0

    .line 418
    .local v27, "rootShell":Lorg/sufficientlysecure/rootcommands/Shell;
    :try_start_21c
    invoke-static {}, Lorg/sufficientlysecure/rootcommands/Shell;->startRootShell()Lorg/sufficientlysecure/rootcommands/Shell;
    :try_end_21f
    .catch Ljava/lang/Exception; {:try_start_21c .. :try_end_21f} :catch_476

    move-result-object v27

    .line 425
    :goto_220
    :try_start_220
    move-object/from16 v0, p0

    iget-object v0, v0, Lorg/pornaway/service/ApplyService;->mService:Landroid/content/Context;

    move-object/from16 v29, v0

    invoke-static/range {v29 .. v29}, Lorg/pornaway/helper/PreferenceHelper;->getApplyMethod(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v29

    const-string v30, "writeToSystem"

    invoke-virtual/range {v29 .. v30}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v29

    if-eqz v29, :cond_484

    .line 427
    move-object/from16 v0, p0

    iget-object v0, v0, Lorg/pornaway/service/ApplyService;->mService:Landroid/content/Context;

    move-object/from16 v29, v0

    sget-object v30, Lorg/pornaway/util/Constants;->ANDROID_SYSTEM_ETC_HOSTS:Ljava/lang/String;

    move-object/from16 v0, v29

    move-object/from16 v1, v30

    move-object/from16 v2, v27

    invoke-static {v0, v1, v2}, Lorg/pornaway/util/ApplyUtils;->copyHostsFile(Landroid/content/Context;Ljava/lang/String;Lorg/sufficientlysecure/rootcommands/Shell;)V
    :try_end_243
    .catch Lorg/pornaway/util/NotEnoughSpaceException; {:try_start_220 .. :try_end_243} :catch_4a9
    .catch Lorg/pornaway/util/RemountException; {:try_start_220 .. :try_end_243} :catch_4de
    .catch Lorg/pornaway/util/CommandException; {:try_start_220 .. :try_end_243} :catch_51b

    .line 454
    :cond_243
    :goto_243
    move-object/from16 v0, p0

    iget-object v0, v0, Lorg/pornaway/service/ApplyService;->mService:Landroid/content/Context;

    move-object/from16 v29, v0

    const-string v30, "hosts"

    invoke-virtual/range {v29 .. v30}, Landroid/content/Context;->deleteFile(Ljava/lang/String;)Z

    .line 459
    move-object/from16 v0, p0

    iget-object v0, v0, Lorg/pornaway/service/ApplyService;->mService:Landroid/content/Context;

    move-object/from16 v29, v0

    invoke-static/range {v29 .. v29}, Lorg/pornaway/provider/ProviderHelper;->updateAllEnabledHostsSourcesLastModifiedLocalFromOnline(Landroid/content/Context;)V

    .line 463
    const/16 v29, 0x1

    move/from16 v0, v26

    move/from16 v1, v29

    if-ne v0, v1, :cond_27b

    .line 464
    move-object/from16 v0, p0

    iget-object v0, v0, Lorg/pornaway/service/ApplyService;->mService:Landroid/content/Context;

    move-object/from16 v29, v0

    invoke-static/range {v29 .. v29}, Lorg/pornaway/helper/PreferenceHelper;->getApplyMethod(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v29

    const-string v30, "writeToSystem"

    invoke-virtual/range {v29 .. v30}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v29

    if-eqz v29, :cond_52b

    .line 468
    sget-object v29, Lorg/pornaway/util/Constants;->ANDROID_SYSTEM_ETC_HOSTS:Ljava/lang/String;

    invoke-static/range {v29 .. v29}, Lorg/pornaway/util/ApplyUtils;->isHostsFileCorrect(Ljava/lang/String;)Z

    move-result v29

    if-nez v29, :cond_27b

    .line 469
    const/16 v26, 0x8

    .line 510
    :cond_27b
    :goto_27b
    :try_start_27b
    invoke-virtual/range {v27 .. v27}, Lorg/sufficientlysecure/rootcommands/Shell;->close()V
    :try_end_27e
    .catch Ljava/lang/Exception; {:try_start_27b .. :try_end_27e} :catch_5b9

    .line 516
    :goto_27e
    const/16 v29, 0x1

    move/from16 v0, v26

    move/from16 v1, v29

    if-ne v0, v1, :cond_29b

    .line 517
    move-object/from16 v0, p0

    iget-object v0, v0, Lorg/pornaway/service/ApplyService;->mService:Landroid/content/Context;

    move-object/from16 v29, v0

    invoke-static/range {v29 .. v29}, Lorg/pornaway/util/ApplyUtils;->isApnProxySet(Landroid/content/Context;)Z

    move-result v29

    if-eqz v29, :cond_29b

    .line 518
    const-string v29, "PornAway"

    const-string v30, "APN proxy is set!"

    invoke-static/range {v29 .. v30}, Lorg/pornaway/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 519
    const/16 v26, 0x10

    .line 523
    :cond_29b
    return v26

    .line 344
    .end local v5    # "bos":Ljava/io/BufferedOutputStream;
    .end local v27    # "rootShell":Lorg/sufficientlysecure/rootcommands/Shell;
    .restart local v6    # "bos":Ljava/io/BufferedOutputStream;
    .restart local v9    # "enabledHostsSources":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    .restart local v10    # "fis":Ljava/io/FileInputStream;
    .restart local v11    # "formatter":Ljava/text/SimpleDateFormat;
    .restart local v12    # "fos":Ljava/io/FileOutputStream;
    .restart local v13    # "header":Ljava/lang/String;
    .restart local v20    # "now":Ljava/util/Date;
    .restart local v21    # "parser":Lorg/pornaway/util/HostsParser;
    .restart local v22    # "reader":Ljava/io/BufferedReader;
    .restart local v28    # "source":Ljava/lang/String;
    :cond_29c
    :try_start_29c
    sget-object v29, Lorg/pornaway/util/Constants;->LINE_SEPERATOR:Ljava/lang/String;

    invoke-virtual/range {v29 .. v29}, Ljava/lang/String;->getBytes()[B

    move-result-object v29

    move-object/from16 v0, v29

    invoke-virtual {v6, v0}, Ljava/io/BufferedOutputStream;->write([B)V

    .line 346
    move-object/from16 v0, p0

    iget-object v0, v0, Lorg/pornaway/service/ApplyService;->mService:Landroid/content/Context;

    move-object/from16 v29, v0

    invoke-static/range {v29 .. v29}, Lorg/pornaway/helper/PreferenceHelper;->getRedirectionIP(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v23

    .line 349
    .local v23, "redirectionIP":Ljava/lang/String;
    new-instance v29, Ljava/lang/StringBuilder;

    invoke-direct/range {v29 .. v29}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v30, Lorg/pornaway/util/Constants;->LINE_SEPERATOR:Ljava/lang/String;

    invoke-virtual/range {v29 .. v30}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v29

    const-string v30, "127.0.0.1"

    invoke-virtual/range {v29 .. v30}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v29

    const-string v30, " "

    invoke-virtual/range {v29 .. v30}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v29

    const-string v30, "localhost"

    invoke-virtual/range {v29 .. v30}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v29

    sget-object v30, Lorg/pornaway/util/Constants;->LINE_SEPERATOR:Ljava/lang/String;

    invoke-virtual/range {v29 .. v30}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v29

    const-string v30, "::1"

    invoke-virtual/range {v29 .. v30}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v29

    const-string v30, " "

    invoke-virtual/range {v29 .. v30}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v29

    const-string v30, "localhost"

    invoke-virtual/range {v29 .. v30}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v29

    invoke-virtual/range {v29 .. v29}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v19

    .line 352
    .local v19, "localhost":Ljava/lang/String;
    invoke-virtual/range {v19 .. v19}, Ljava/lang/String;->getBytes()[B

    move-result-object v29

    move-object/from16 v0, v29

    invoke-virtual {v6, v0}, Ljava/io/BufferedOutputStream;->write([B)V

    .line 354
    sget-object v29, Lorg/pornaway/util/Constants;->LINE_SEPERATOR:Ljava/lang/String;

    invoke-virtual/range {v29 .. v29}, Ljava/lang/String;->getBytes()[B

    move-result-object v29

    move-object/from16 v0, v29

    invoke-virtual {v6, v0}, Ljava/io/BufferedOutputStream;->write([B)V

    .line 359
    move-object/from16 v0, p0

    iget-object v0, v0, Lorg/pornaway/service/ApplyService;->mService:Landroid/content/Context;

    move-object/from16 v29, v0

    invoke-static/range {v29 .. v29}, Lorg/pornaway/helper/PreferenceHelper;->getEnableIpv6(Landroid/content/Context;)Z

    move-result v29

    if-eqz v29, :cond_396

    .line 360
    invoke-virtual/range {v21 .. v21}, Lorg/pornaway/util/HostsParser;->getBlacklist()Lgnu/trove/set/hash/THashSet;

    move-result-object v29

    invoke-virtual/range {v29 .. v29}, Lgnu/trove/set/hash/THashSet;->iterator()Lgnu/trove/iterator/hash/TObjectHashIterator;

    move-result-object v29

    :goto_312
    invoke-interface/range {v29 .. v29}, Ljava/util/Iterator;->hasNext()Z

    move-result v30

    if-eqz v30, :cond_3e2

    invoke-interface/range {v29 .. v29}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v15

    check-cast v15, Ljava/lang/String;

    .line 361
    .local v15, "hostname":Ljava/lang/String;
    new-instance v30, Ljava/lang/StringBuilder;

    invoke-direct/range {v30 .. v30}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v31, Lorg/pornaway/util/Constants;->LINE_SEPERATOR:Ljava/lang/String;

    invoke-virtual/range {v30 .. v31}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v30

    move-object/from16 v0, v30

    move-object/from16 v1, v23

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v30

    const-string v31, " "

    invoke-virtual/range {v30 .. v31}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v30

    move-object/from16 v0, v30

    invoke-virtual {v0, v15}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v30

    invoke-virtual/range {v30 .. v30}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v17

    .line 362
    .local v17, "line":Ljava/lang/String;
    new-instance v30, Ljava/lang/StringBuilder;

    invoke-direct/range {v30 .. v30}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v31, Lorg/pornaway/util/Constants;->LINE_SEPERATOR:Ljava/lang/String;

    invoke-virtual/range {v30 .. v31}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v30

    const-string v31, "::1 "

    invoke-virtual/range {v30 .. v31}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v30

    move-object/from16 v0, v30

    invoke-virtual {v0, v15}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v30

    invoke-virtual/range {v30 .. v30}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v18

    .line 363
    .local v18, "linev6":Ljava/lang/String;
    invoke-virtual/range {v17 .. v17}, Ljava/lang/String;->getBytes()[B

    move-result-object v30

    move-object/from16 v0, v30

    invoke-virtual {v6, v0}, Ljava/io/BufferedOutputStream;->write([B)V

    .line 364
    invoke-virtual/range {v18 .. v18}, Ljava/lang/String;->getBytes()[B

    move-result-object v30

    move-object/from16 v0, v30

    invoke-virtual {v6, v0}, Ljava/io/BufferedOutputStream;->write([B)V
    :try_end_36e
    .catch Ljava/io/FileNotFoundException; {:try_start_29c .. :try_end_36e} :catch_1cd
    .catch Ljava/io/IOException; {:try_start_29c .. :try_end_36e} :catch_36f
    .catchall {:try_start_29c .. :try_end_36e} :catchall_3d7

    goto :goto_312

    .line 392
    .end local v11    # "formatter":Ljava/text/SimpleDateFormat;
    .end local v13    # "header":Ljava/lang/String;
    .end local v15    # "hostname":Ljava/lang/String;
    .end local v17    # "line":Ljava/lang/String;
    .end local v18    # "linev6":Ljava/lang/String;
    .end local v19    # "localhost":Ljava/lang/String;
    .end local v20    # "now":Ljava/util/Date;
    .end local v23    # "redirectionIP":Ljava/lang/String;
    .end local v28    # "source":Ljava/lang/String;
    :catch_36f
    move-exception v8

    move-object v5, v6

    .line 393
    .end local v6    # "bos":Ljava/io/BufferedOutputStream;
    .end local v9    # "enabledHostsSources":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    .end local v10    # "fis":Ljava/io/FileInputStream;
    .end local v12    # "fos":Ljava/io/FileOutputStream;
    .end local v21    # "parser":Lorg/pornaway/util/HostsParser;
    .end local v22    # "reader":Ljava/io/BufferedReader;
    .restart local v5    # "bos":Ljava/io/BufferedOutputStream;
    .local v8, "e":Ljava/io/IOException;
    :goto_371
    :try_start_371
    const-string v29, "PornAway"

    const-string v30, "files can not be written or read"

    move-object/from16 v0, v29

    move-object/from16 v1, v30

    invoke-static {v0, v1, v8}, Lorg/pornaway/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    :try_end_37c
    .catchall {:try_start_371 .. :try_end_37c} :catchall_5c7

    .line 395
    const/16 v26, 0x2

    .line 399
    if-eqz v5, :cond_1e4

    .line 400
    :try_start_380
    invoke-virtual {v5}, Ljava/io/BufferedOutputStream;->flush()V

    .line 401
    invoke-virtual {v5}, Ljava/io/BufferedOutputStream;->close()V
    :try_end_386
    .catch Ljava/lang/Exception; {:try_start_380 .. :try_end_386} :catch_388

    goto/16 :goto_1e4

    .line 404
    :catch_388
    move-exception v8

    .line 405
    .local v8, "e":Ljava/lang/Exception;
    const-string v29, "PornAway"

    const-string v30, "Error closing output streams"

    move-object/from16 v0, v29

    move-object/from16 v1, v30

    invoke-static {v0, v1, v8}, Lorg/pornaway/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto/16 :goto_1e4

    .line 367
    .end local v5    # "bos":Ljava/io/BufferedOutputStream;
    .end local v8    # "e":Ljava/lang/Exception;
    .restart local v6    # "bos":Ljava/io/BufferedOutputStream;
    .restart local v9    # "enabledHostsSources":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    .restart local v10    # "fis":Ljava/io/FileInputStream;
    .restart local v11    # "formatter":Ljava/text/SimpleDateFormat;
    .restart local v12    # "fos":Ljava/io/FileOutputStream;
    .restart local v13    # "header":Ljava/lang/String;
    .restart local v19    # "localhost":Ljava/lang/String;
    .restart local v20    # "now":Ljava/util/Date;
    .restart local v21    # "parser":Lorg/pornaway/util/HostsParser;
    .restart local v22    # "reader":Ljava/io/BufferedReader;
    .restart local v23    # "redirectionIP":Ljava/lang/String;
    .restart local v28    # "source":Ljava/lang/String;
    :cond_396
    :try_start_396
    invoke-virtual/range {v21 .. v21}, Lorg/pornaway/util/HostsParser;->getBlacklist()Lgnu/trove/set/hash/THashSet;

    move-result-object v29

    invoke-virtual/range {v29 .. v29}, Lgnu/trove/set/hash/THashSet;->iterator()Lgnu/trove/iterator/hash/TObjectHashIterator;

    move-result-object v29

    :goto_39e
    invoke-interface/range {v29 .. v29}, Ljava/util/Iterator;->hasNext()Z

    move-result v30

    if-eqz v30, :cond_3e2

    invoke-interface/range {v29 .. v29}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v15

    check-cast v15, Ljava/lang/String;

    .line 368
    .restart local v15    # "hostname":Ljava/lang/String;
    new-instance v30, Ljava/lang/StringBuilder;

    invoke-direct/range {v30 .. v30}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v31, Lorg/pornaway/util/Constants;->LINE_SEPERATOR:Ljava/lang/String;

    invoke-virtual/range {v30 .. v31}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v30

    move-object/from16 v0, v30

    move-object/from16 v1, v23

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v30

    const-string v31, " "

    invoke-virtual/range {v30 .. v31}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v30

    move-object/from16 v0, v30

    invoke-virtual {v0, v15}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v30

    invoke-virtual/range {v30 .. v30}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v17

    .line 369
    .restart local v17    # "line":Ljava/lang/String;
    invoke-virtual/range {v17 .. v17}, Ljava/lang/String;->getBytes()[B

    move-result-object v30

    move-object/from16 v0, v30

    invoke-virtual {v6, v0}, Ljava/io/BufferedOutputStream;->write([B)V
    :try_end_3d6
    .catch Ljava/io/FileNotFoundException; {:try_start_396 .. :try_end_3d6} :catch_1cd
    .catch Ljava/io/IOException; {:try_start_396 .. :try_end_3d6} :catch_36f
    .catchall {:try_start_396 .. :try_end_3d6} :catchall_3d7

    goto :goto_39e

    .line 398
    .end local v11    # "formatter":Ljava/text/SimpleDateFormat;
    .end local v13    # "header":Ljava/lang/String;
    .end local v15    # "hostname":Ljava/lang/String;
    .end local v17    # "line":Ljava/lang/String;
    .end local v19    # "localhost":Ljava/lang/String;
    .end local v20    # "now":Ljava/util/Date;
    .end local v23    # "redirectionIP":Ljava/lang/String;
    .end local v28    # "source":Ljava/lang/String;
    :catchall_3d7
    move-exception v29

    move-object v5, v6

    .line 399
    .end local v6    # "bos":Ljava/io/BufferedOutputStream;
    .end local v9    # "enabledHostsSources":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    .end local v10    # "fis":Ljava/io/FileInputStream;
    .end local v12    # "fos":Ljava/io/FileOutputStream;
    .end local v21    # "parser":Lorg/pornaway/util/HostsParser;
    .end local v22    # "reader":Ljava/io/BufferedReader;
    .restart local v5    # "bos":Ljava/io/BufferedOutputStream;
    :goto_3d9
    if-eqz v5, :cond_3e1

    .line 400
    :try_start_3db
    invoke-virtual {v5}, Ljava/io/BufferedOutputStream;->flush()V

    .line 401
    invoke-virtual {v5}, Ljava/io/BufferedOutputStream;->close()V
    :try_end_3e1
    .catch Ljava/lang/Exception; {:try_start_3db .. :try_end_3e1} :catch_468

    .line 406
    :cond_3e1
    :goto_3e1
    throw v29

    .line 376
    .end local v5    # "bos":Ljava/io/BufferedOutputStream;
    .restart local v6    # "bos":Ljava/io/BufferedOutputStream;
    .restart local v9    # "enabledHostsSources":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    .restart local v10    # "fis":Ljava/io/FileInputStream;
    .restart local v11    # "formatter":Ljava/text/SimpleDateFormat;
    .restart local v12    # "fos":Ljava/io/FileOutputStream;
    .restart local v13    # "header":Ljava/lang/String;
    .restart local v19    # "localhost":Ljava/lang/String;
    .restart local v20    # "now":Ljava/util/Date;
    .restart local v21    # "parser":Lorg/pornaway/util/HostsParser;
    .restart local v22    # "reader":Ljava/io/BufferedReader;
    .restart local v23    # "redirectionIP":Ljava/lang/String;
    .restart local v28    # "source":Ljava/lang/String;
    :cond_3e2
    :try_start_3e2
    invoke-virtual/range {v21 .. v21}, Lorg/pornaway/util/HostsParser;->getRedirectionList()Lgnu/trove/map/hash/THashMap;

    move-result-object v29

    invoke-virtual/range {v29 .. v29}, Lgnu/trove/map/hash/THashMap;->entrySet()Ljava/util/Set;

    move-result-object v29

    invoke-interface/range {v29 .. v29}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v29

    :goto_3ee
    invoke-interface/range {v29 .. v29}, Ljava/util/Iterator;->hasNext()Z

    move-result v30

    if-eqz v30, :cond_435

    invoke-interface/range {v29 .. v29}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v16

    check-cast v16, Ljava/util/Map$Entry;

    .line 377
    .local v16, "item":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-interface/range {v16 .. v16}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v24

    check-cast v24, Ljava/lang/String;

    .line 378
    .local v24, "redirectionItemHostname":Ljava/lang/String;
    invoke-interface/range {v16 .. v16}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v25

    check-cast v25, Ljava/lang/String;

    .line 380
    .local v25, "redirectionItemIP":Ljava/lang/String;
    new-instance v30, Ljava/lang/StringBuilder;

    invoke-direct/range {v30 .. v30}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v31, Lorg/pornaway/util/Constants;->LINE_SEPERATOR:Ljava/lang/String;

    invoke-virtual/range {v30 .. v31}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v30

    move-object/from16 v0, v30

    move-object/from16 v1, v25

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v30

    const-string v31, " "

    invoke-virtual/range {v30 .. v31}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v30

    move-object/from16 v0, v30

    move-object/from16 v1, v24

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v30

    invoke-virtual/range {v30 .. v30}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v17

    .line 381
    .restart local v17    # "line":Ljava/lang/String;
    invoke-virtual/range {v17 .. v17}, Ljava/lang/String;->getBytes()[B

    move-result-object v30

    move-object/from16 v0, v30

    invoke-virtual {v6, v0}, Ljava/io/BufferedOutputStream;->write([B)V

    goto :goto_3ee

    .line 386
    .end local v16    # "item":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    .end local v17    # "line":Ljava/lang/String;
    .end local v24    # "redirectionItemHostname":Ljava/lang/String;
    .end local v25    # "redirectionItemIP":Ljava/lang/String;
    :cond_435
    sget-object v29, Lorg/pornaway/util/Constants;->LINE_SEPERATOR:Ljava/lang/String;

    invoke-virtual/range {v29 .. v29}, Ljava/lang/String;->getBytes()[B

    move-result-object v29

    move-object/from16 v0, v29

    invoke-virtual {v6, v0}, Ljava/io/BufferedOutputStream;->write([B)V
    :try_end_440
    .catch Ljava/io/FileNotFoundException; {:try_start_3e2 .. :try_end_440} :catch_1cd
    .catch Ljava/io/IOException; {:try_start_3e2 .. :try_end_440} :catch_36f
    .catchall {:try_start_3e2 .. :try_end_440} :catchall_3d7

    .line 399
    if-eqz v6, :cond_448

    .line 400
    :try_start_442
    invoke-virtual {v6}, Ljava/io/BufferedOutputStream;->flush()V

    .line 401
    invoke-virtual {v6}, Ljava/io/BufferedOutputStream;->close()V
    :try_end_448
    .catch Ljava/lang/Exception; {:try_start_442 .. :try_end_448} :catch_44b

    :cond_448
    move-object v5, v6

    .line 406
    .end local v6    # "bos":Ljava/io/BufferedOutputStream;
    .restart local v5    # "bos":Ljava/io/BufferedOutputStream;
    goto/16 :goto_1e4

    .line 404
    .end local v5    # "bos":Ljava/io/BufferedOutputStream;
    .restart local v6    # "bos":Ljava/io/BufferedOutputStream;
    :catch_44b
    move-exception v8

    .line 405
    .restart local v8    # "e":Ljava/lang/Exception;
    const-string v29, "PornAway"

    const-string v30, "Error closing output streams"

    move-object/from16 v0, v29

    move-object/from16 v1, v30

    invoke-static {v0, v1, v8}, Lorg/pornaway/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    move-object v5, v6

    .line 407
    .end local v6    # "bos":Ljava/io/BufferedOutputStream;
    .restart local v5    # "bos":Ljava/io/BufferedOutputStream;
    goto/16 :goto_1e4

    .line 404
    .end local v9    # "enabledHostsSources":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    .end local v10    # "fis":Ljava/io/FileInputStream;
    .end local v11    # "formatter":Ljava/text/SimpleDateFormat;
    .end local v12    # "fos":Ljava/io/FileOutputStream;
    .end local v13    # "header":Ljava/lang/String;
    .end local v19    # "localhost":Ljava/lang/String;
    .end local v20    # "now":Ljava/util/Date;
    .end local v21    # "parser":Lorg/pornaway/util/HostsParser;
    .end local v22    # "reader":Ljava/io/BufferedReader;
    .end local v23    # "redirectionIP":Ljava/lang/String;
    .end local v28    # "source":Ljava/lang/String;
    .local v8, "e":Ljava/io/FileNotFoundException;
    :catch_45a
    move-exception v8

    .line 405
    .local v8, "e":Ljava/lang/Exception;
    const-string v29, "PornAway"

    const-string v30, "Error closing output streams"

    move-object/from16 v0, v29

    move-object/from16 v1, v30

    invoke-static {v0, v1, v8}, Lorg/pornaway/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto/16 :goto_1e4

    .line 404
    .end local v8    # "e":Ljava/lang/Exception;
    :catch_468
    move-exception v8

    .line 405
    .restart local v8    # "e":Ljava/lang/Exception;
    const-string v30, "PornAway"

    const-string v31, "Error closing output streams"

    move-object/from16 v0, v30

    move-object/from16 v1, v31

    invoke-static {v0, v1, v8}, Lorg/pornaway/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto/16 :goto_3e1

    .line 419
    .end local v8    # "e":Ljava/lang/Exception;
    .restart local v27    # "rootShell":Lorg/sufficientlysecure/rootcommands/Shell;
    :catch_476
    move-exception v8

    .line 420
    .restart local v8    # "e":Ljava/lang/Exception;
    const-string v29, "PornAway"

    const-string v30, "Problem opening a root shell!"

    move-object/from16 v0, v29

    move-object/from16 v1, v30

    invoke-static {v0, v1, v8}, Lorg/pornaway/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto/16 :goto_220

    .line 428
    .end local v8    # "e":Ljava/lang/Exception;
    :cond_484
    :try_start_484
    move-object/from16 v0, p0

    iget-object v0, v0, Lorg/pornaway/service/ApplyService;->mService:Landroid/content/Context;

    move-object/from16 v29, v0

    invoke-static/range {v29 .. v29}, Lorg/pornaway/helper/PreferenceHelper;->getApplyMethod(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v29

    const-string v30, "writeToDataData"

    invoke-virtual/range {v29 .. v30}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v29

    if-eqz v29, :cond_4b9

    .line 430
    move-object/from16 v0, p0

    iget-object v0, v0, Lorg/pornaway/service/ApplyService;->mService:Landroid/content/Context;

    move-object/from16 v29, v0

    sget-object v30, Lorg/pornaway/util/Constants;->ANDROID_DATA_DATA_HOSTS:Ljava/lang/String;

    move-object/from16 v0, v29

    move-object/from16 v1, v30

    move-object/from16 v2, v27

    invoke-static {v0, v1, v2}, Lorg/pornaway/util/ApplyUtils;->copyHostsFile(Landroid/content/Context;Ljava/lang/String;Lorg/sufficientlysecure/rootcommands/Shell;)V
    :try_end_4a7
    .catch Lorg/pornaway/util/NotEnoughSpaceException; {:try_start_484 .. :try_end_4a7} :catch_4a9
    .catch Lorg/pornaway/util/RemountException; {:try_start_484 .. :try_end_4a7} :catch_4de
    .catch Lorg/pornaway/util/CommandException; {:try_start_484 .. :try_end_4a7} :catch_51b

    goto/16 :goto_243

    .line 439
    :catch_4a9
    move-exception v8

    .line 440
    .local v8, "e":Lorg/pornaway/util/NotEnoughSpaceException;
    const-string v29, "PornAway"

    const-string v30, "Exception: "

    move-object/from16 v0, v29

    move-object/from16 v1, v30

    invoke-static {v0, v1, v8}, Lorg/pornaway/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 442
    const/16 v26, 0xa

    .line 451
    goto/16 :goto_243

    .line 431
    .end local v8    # "e":Lorg/pornaway/util/NotEnoughSpaceException;
    :cond_4b9
    :try_start_4b9
    move-object/from16 v0, p0

    iget-object v0, v0, Lorg/pornaway/service/ApplyService;->mService:Landroid/content/Context;

    move-object/from16 v29, v0

    invoke-static/range {v29 .. v29}, Lorg/pornaway/helper/PreferenceHelper;->getApplyMethod(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v29

    const-string v30, "writeToData"

    invoke-virtual/range {v29 .. v30}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v29

    if-eqz v29, :cond_4ee

    .line 433
    move-object/from16 v0, p0

    iget-object v0, v0, Lorg/pornaway/service/ApplyService;->mService:Landroid/content/Context;

    move-object/from16 v29, v0

    sget-object v30, Lorg/pornaway/util/Constants;->ANDROID_DATA_HOSTS:Ljava/lang/String;

    move-object/from16 v0, v29

    move-object/from16 v1, v30

    move-object/from16 v2, v27

    invoke-static {v0, v1, v2}, Lorg/pornaway/util/ApplyUtils;->copyHostsFile(Landroid/content/Context;Ljava/lang/String;Lorg/sufficientlysecure/rootcommands/Shell;)V
    :try_end_4dc
    .catch Lorg/pornaway/util/NotEnoughSpaceException; {:try_start_4b9 .. :try_end_4dc} :catch_4a9
    .catch Lorg/pornaway/util/RemountException; {:try_start_4b9 .. :try_end_4dc} :catch_4de
    .catch Lorg/pornaway/util/CommandException; {:try_start_4b9 .. :try_end_4dc} :catch_51b

    goto/16 :goto_243

    .line 443
    :catch_4de
    move-exception v8

    .line 444
    .local v8, "e":Lorg/pornaway/util/RemountException;
    const-string v29, "PornAway"

    const-string v30, "Exception: "

    move-object/from16 v0, v29

    move-object/from16 v1, v30

    invoke-static {v0, v1, v8}, Lorg/pornaway/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 446
    const/16 v26, 0xb

    .line 451
    goto/16 :goto_243

    .line 434
    .end local v8    # "e":Lorg/pornaway/util/RemountException;
    :cond_4ee
    :try_start_4ee
    move-object/from16 v0, p0

    iget-object v0, v0, Lorg/pornaway/service/ApplyService;->mService:Landroid/content/Context;

    move-object/from16 v29, v0

    invoke-static/range {v29 .. v29}, Lorg/pornaway/helper/PreferenceHelper;->getApplyMethod(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v29

    const-string v30, "customTarget"

    invoke-virtual/range {v29 .. v30}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v29

    if-eqz v29, :cond_243

    .line 436
    move-object/from16 v0, p0

    iget-object v0, v0, Lorg/pornaway/service/ApplyService;->mService:Landroid/content/Context;

    move-object/from16 v29, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lorg/pornaway/service/ApplyService;->mService:Landroid/content/Context;

    move-object/from16 v30, v0

    invoke-static/range {v30 .. v30}, Lorg/pornaway/helper/PreferenceHelper;->getCustomTarget(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v30

    move-object/from16 v0, v29

    move-object/from16 v1, v30

    move-object/from16 v2, v27

    invoke-static {v0, v1, v2}, Lorg/pornaway/util/ApplyUtils;->copyHostsFile(Landroid/content/Context;Ljava/lang/String;Lorg/sufficientlysecure/rootcommands/Shell;)V
    :try_end_519
    .catch Lorg/pornaway/util/NotEnoughSpaceException; {:try_start_4ee .. :try_end_519} :catch_4a9
    .catch Lorg/pornaway/util/RemountException; {:try_start_4ee .. :try_end_519} :catch_4de
    .catch Lorg/pornaway/util/CommandException; {:try_start_4ee .. :try_end_519} :catch_51b

    goto/16 :goto_243

    .line 447
    :catch_51b
    move-exception v8

    .line 448
    .local v8, "e":Lorg/pornaway/util/CommandException;
    const-string v29, "PornAway"

    const-string v30, "Exception: "

    move-object/from16 v0, v29

    move-object/from16 v1, v30

    invoke-static {v0, v1, v8}, Lorg/pornaway/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 450
    const/16 v26, 0xc

    goto/16 :goto_243

    .line 471
    .end local v8    # "e":Lorg/pornaway/util/CommandException;
    :cond_52b
    move-object/from16 v0, p0

    iget-object v0, v0, Lorg/pornaway/service/ApplyService;->mService:Landroid/content/Context;

    move-object/from16 v29, v0

    invoke-static/range {v29 .. v29}, Lorg/pornaway/helper/PreferenceHelper;->getApplyMethod(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v29

    const-string v30, "writeToDataData"

    invoke-virtual/range {v29 .. v30}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v29

    if-eqz v29, :cond_559

    .line 475
    sget-object v29, Lorg/pornaway/util/Constants;->ANDROID_DATA_DATA_HOSTS:Ljava/lang/String;

    invoke-static/range {v29 .. v29}, Lorg/pornaway/util/ApplyUtils;->isHostsFileCorrect(Ljava/lang/String;)Z

    move-result v29

    if-nez v29, :cond_549

    .line 476
    const/16 v26, 0x8

    goto/16 :goto_27b

    .line 478
    :cond_549
    sget-object v29, Lorg/pornaway/util/Constants;->ANDROID_DATA_DATA_HOSTS:Ljava/lang/String;

    move-object/from16 v0, v29

    move-object/from16 v1, v27

    invoke-static {v0, v1}, Lorg/pornaway/util/ApplyUtils;->isSymlinkCorrect(Ljava/lang/String;Lorg/sufficientlysecure/rootcommands/Shell;)Z

    move-result v29

    if-nez v29, :cond_27b

    .line 479
    const/16 v26, 0x9

    goto/16 :goto_27b

    .line 482
    :cond_559
    move-object/from16 v0, p0

    iget-object v0, v0, Lorg/pornaway/service/ApplyService;->mService:Landroid/content/Context;

    move-object/from16 v29, v0

    invoke-static/range {v29 .. v29}, Lorg/pornaway/helper/PreferenceHelper;->getApplyMethod(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v29

    const-string v30, "writeToData"

    invoke-virtual/range {v29 .. v30}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v29

    if-eqz v29, :cond_587

    .line 486
    sget-object v29, Lorg/pornaway/util/Constants;->ANDROID_DATA_HOSTS:Ljava/lang/String;

    invoke-static/range {v29 .. v29}, Lorg/pornaway/util/ApplyUtils;->isHostsFileCorrect(Ljava/lang/String;)Z

    move-result v29

    if-nez v29, :cond_577

    .line 487
    const/16 v26, 0x8

    goto/16 :goto_27b

    .line 489
    :cond_577
    sget-object v29, Lorg/pornaway/util/Constants;->ANDROID_DATA_HOSTS:Ljava/lang/String;

    move-object/from16 v0, v29

    move-object/from16 v1, v27

    invoke-static {v0, v1}, Lorg/pornaway/util/ApplyUtils;->isSymlinkCorrect(Ljava/lang/String;Lorg/sufficientlysecure/rootcommands/Shell;)Z

    move-result v29

    if-nez v29, :cond_27b

    .line 490
    const/16 v26, 0x9

    goto/16 :goto_27b

    .line 493
    :cond_587
    move-object/from16 v0, p0

    iget-object v0, v0, Lorg/pornaway/service/ApplyService;->mService:Landroid/content/Context;

    move-object/from16 v29, v0

    invoke-static/range {v29 .. v29}, Lorg/pornaway/helper/PreferenceHelper;->getApplyMethod(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v29

    const-string v30, "customTarget"

    invoke-virtual/range {v29 .. v30}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v29

    if-eqz v29, :cond_27b

    .line 497
    move-object/from16 v0, p0

    iget-object v0, v0, Lorg/pornaway/service/ApplyService;->mService:Landroid/content/Context;

    move-object/from16 v29, v0

    invoke-static/range {v29 .. v29}, Lorg/pornaway/helper/PreferenceHelper;->getCustomTarget(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v7

    .line 499
    .local v7, "customTarget":Ljava/lang/String;
    invoke-static {v7}, Lorg/pornaway/util/ApplyUtils;->isHostsFileCorrect(Ljava/lang/String;)Z

    move-result v29

    if-nez v29, :cond_5ad

    .line 500
    const/16 v26, 0x8

    goto/16 :goto_27b

    .line 502
    :cond_5ad
    move-object/from16 v0, v27

    invoke-static {v7, v0}, Lorg/pornaway/util/ApplyUtils;->isSymlinkCorrect(Ljava/lang/String;Lorg/sufficientlysecure/rootcommands/Shell;)Z

    move-result v29

    if-nez v29, :cond_27b

    .line 503
    const/16 v26, 0x9

    goto/16 :goto_27b

    .line 511
    .end local v7    # "customTarget":Ljava/lang/String;
    :catch_5b9
    move-exception v8

    .line 512
    .local v8, "e":Ljava/lang/Exception;
    const-string v29, "PornAway"

    const-string v30, "Problem closing the root shell!"

    move-object/from16 v0, v29

    move-object/from16 v1, v30

    invoke-static {v0, v1, v8}, Lorg/pornaway/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto/16 :goto_27e

    .line 398
    .end local v8    # "e":Ljava/lang/Exception;
    .end local v27    # "rootShell":Lorg/sufficientlysecure/rootcommands/Shell;
    :catchall_5c7
    move-exception v29

    goto/16 :goto_3d9

    .line 392
    :catch_5ca
    move-exception v8

    goto/16 :goto_371

    .line 388
    :catch_5cd
    move-exception v8

    goto/16 :goto_1cf
.end method

.method public doWakefulWork(Landroid/content/Intent;)V
    .registers 11
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    const/4 v8, 0x0

    const/4 v7, 0x1

    const/4 v6, 0x0

    .line 94
    iget-object v3, p0, Lorg/pornaway/service/ApplyService;->mService:Landroid/content/Context;

    invoke-static {v3, v7}, Lorg/pornaway/ui/BaseActivity;->setButtonsDisabledBroadcast(Landroid/content/Context;Z)V

    .line 97
    invoke-direct {p0}, Lorg/pornaway/service/ApplyService;->download()I

    move-result v1

    .line 98
    .local v1, "downloadResult":I
    const-string v3, "PornAway"

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Download result: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Lorg/pornaway/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 100
    if-ne v1, v7, :cond_6e

    .line 102
    invoke-virtual {p0}, Lorg/pornaway/service/ApplyService;->apply()I

    move-result v0

    .line 104
    .local v0, "applyResult":I
    invoke-direct {p0}, Lorg/pornaway/service/ApplyService;->cancelApplyNotification()V

    .line 106
    iget-object v3, p0, Lorg/pornaway/service/ApplyService;->mService:Landroid/content/Context;

    invoke-static {v3, v6}, Lorg/pornaway/ui/BaseActivity;->setButtonsDisabledBroadcast(Landroid/content/Context;Z)V

    .line 107
    const-string v3, "PornAway"

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Apply result: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Lorg/pornaway/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 109
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    iget v4, p0, Lorg/pornaway/service/ApplyService;->mNumberOfDownloads:I

    iget v5, p0, Lorg/pornaway/service/ApplyService;->mNumberOfFailedDownloads:I

    sub-int/2addr v4, v5

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "/"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget v4, p0, Lorg/pornaway/service/ApplyService;->mNumberOfDownloads:I

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 112
    .local v2, "successfulDownloads":Ljava/lang/String;
    iget-object v3, p0, Lorg/pornaway/service/ApplyService;->mService:Landroid/content/Context;

    invoke-static {v3, v0, v2}, Lorg/pornaway/helper/ResultHelper;->showNotificationBasedOnResult(Landroid/content/Context;ILjava/lang/String;)V

    .line 125
    .end local v0    # "applyResult":I
    .end local v2    # "successfulDownloads":Ljava/lang/String;
    :goto_6d
    return-void

    .line 113
    :cond_6e
    const/4 v3, 0x6

    if-ne v1, v3, :cond_7f

    .line 114
    invoke-direct {p0}, Lorg/pornaway/service/ApplyService;->cancelApplyNotification()V

    .line 116
    iget-object v3, p0, Lorg/pornaway/service/ApplyService;->mService:Landroid/content/Context;

    invoke-static {v3, v6}, Lorg/pornaway/ui/BaseActivity;->setButtonsDisabledBroadcast(Landroid/content/Context;Z)V

    .line 118
    iget-object v3, p0, Lorg/pornaway/service/ApplyService;->mService:Landroid/content/Context;

    invoke-static {v3, v1, v8}, Lorg/pornaway/helper/ResultHelper;->showNotificationBasedOnResult(Landroid/content/Context;ILjava/lang/String;)V

    goto :goto_6d

    .line 120
    :cond_7f
    invoke-direct {p0}, Lorg/pornaway/service/ApplyService;->cancelApplyNotification()V

    .line 122
    iget-object v3, p0, Lorg/pornaway/service/ApplyService;->mService:Landroid/content/Context;

    invoke-static {v3, v6}, Lorg/pornaway/ui/BaseActivity;->setButtonsDisabledBroadcast(Landroid/content/Context;Z)V

    .line 123
    iget-object v3, p0, Lorg/pornaway/service/ApplyService;->mService:Landroid/content/Context;

    invoke-static {v3, v1, v8}, Lorg/pornaway/helper/ResultHelper;->showNotificationBasedOnResult(Landroid/content/Context;ILjava/lang/String;)V

    goto :goto_6d
.end method

.method public onStartCommand(Landroid/content/Intent;II)I
    .registers 6
    .param p1, "intent"    # Landroid/content/Intent;
    .param p2, "flags"    # I
    .param p3, "startId"    # I

    .prologue
    .line 80
    iput-object p0, p0, Lorg/pornaway/service/ApplyService;->mService:Landroid/content/Context;

    .line 82
    iget-object v0, p0, Lorg/pornaway/service/ApplyService;->mService:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    const-string v1, "notification"

    .line 83
    invoke-virtual {v0, v1}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/app/NotificationManager;

    iput-object v0, p0, Lorg/pornaway/service/ApplyService;->mNotificationManager:Landroid/app/NotificationManager;

    .line 85
    invoke-super {p0, p1, p2, p3}, Lcom/commonsware/cwac/wakeful/WakefulIntentService;->onStartCommand(Landroid/content/Intent;II)I

    move-result v0

    return v0
.end method
