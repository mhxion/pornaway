.class public Lorg/adaway/service/DailyListener;
.super Ljava/lang/Object;
.source "DailyListener.java"

# interfaces
.implements Lcom/commonsware/cwac/wakeful/WakefulIntentService$AlarmListener;


# direct methods
.method public constructor <init>()V
    .registers 1

    .prologue
    .line 41
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static randInt(II)I
    .registers 5
    .param p0, "min"    # I
    .param p1, "max"    # I

    .prologue
    .line 43
    new-instance v0, Ljava/util/Random;

    invoke-direct {v0}, Ljava/util/Random;-><init>()V

    .line 44
    .local v0, "rand":Ljava/util/Random;
    sub-int v2, p1, p0

    add-int/lit8 v2, v2, 0x1

    invoke-virtual {v0, v2}, Ljava/util/Random;->nextInt(I)I

    move-result v2

    add-int v1, v2, p0

    .line 45
    .local v1, "randomNum":I
    return v1
.end method


# virtual methods
.method public getMaxAge()J
    .registers 3

    .prologue
    .line 112
    const-wide/32 v0, 0x5274660

    return-wide v0
.end method

.method public scheduleAlarms(Landroid/app/AlarmManager;Landroid/app/PendingIntent;Landroid/content/Context;)V
    .registers 14
    .param p1, "mgr"    # Landroid/app/AlarmManager;
    .param p2, "pi"    # Landroid/app/PendingIntent;
    .param p3, "context"    # Landroid/content/Context;

    .prologue
    const/16 v3, 0xb

    const/4 v1, 0x1

    .line 50
    invoke-static {p3}, Lorg/adaway/helper/PreferenceHelper;->getUpdateCheckDaily(Landroid/content/Context;)Z

    move-result v0

    if-eqz v0, :cond_66

    .line 51
    const/4 v0, 0x3

    const/16 v2, 0x8

    invoke-static {v0, v2}, Lorg/adaway/service/DailyListener;->randInt(II)I

    move-result v8

    .line 52
    .local v8, "randhr":I
    const/16 v0, 0x3a

    invoke-static {v1, v0}, Lorg/adaway/service/DailyListener;->randInt(II)I

    move-result v9

    .line 55
    .local v9, "randmin":I
    invoke-static {}, Ljava/util/Calendar;->getInstance()Ljava/util/Calendar;

    move-result-object v7

    .line 57
    .local v7, "calendar":Ljava/util/Calendar;
    invoke-static {}, Ljava/util/Calendar;->getInstance()Ljava/util/Calendar;

    move-result-object v0

    invoke-virtual {v0, v3}, Ljava/util/Calendar;->get(I)I

    move-result v0

    const/16 v2, 0x9

    if-lt v0, v2, :cond_2a

    .line 58
    const/4 v0, 0x6

    invoke-virtual {v7, v0, v1}, Ljava/util/Calendar;->add(II)V

    .line 60
    :cond_2a
    invoke-virtual {v7, v3, v8}, Ljava/util/Calendar;->set(II)V

    .line 61
    const/16 v0, 0xc

    invoke-virtual {v7, v0, v9}, Ljava/util/Calendar;->set(II)V

    .line 62
    const/16 v0, 0xd

    const/4 v2, 0x0

    invoke-virtual {v7, v0, v2}, Ljava/util/Calendar;->set(II)V

    .line 63
    const-string v0, "AdAway"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Daily update check set for: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v8}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, ":"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v9}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v0, v2}, Lorg/adaway/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 70
    invoke-virtual {v7}, Ljava/util/Calendar;->getTimeInMillis()J

    move-result-wide v2

    const-wide/32 v4, 0x5265c00

    move-object v0, p1

    move-object v6, p2

    invoke-virtual/range {v0 .. v6}, Landroid/app/AlarmManager;->setInexactRepeating(IJJLandroid/app/PendingIntent;)V

    .line 74
    .end local v7    # "calendar":Ljava/util/Calendar;
    .end local v8    # "randhr":I
    .end local v9    # "randmin":I
    :cond_66
    return-void
.end method

.method public sendWakefulWork(Landroid/content/Context;)V
    .registers 9
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    const/4 v6, 0x1

    .line 77
    const-string v4, "connectivity"

    invoke-virtual {p1, v4}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/net/ConnectivityManager;

    .line 79
    .local v0, "cm":Landroid/net/ConnectivityManager;
    invoke-virtual {v0}, Landroid/net/ConnectivityManager;->getActiveNetworkInfo()Landroid/net/NetworkInfo;

    move-result-object v1

    .line 82
    .local v1, "netInfo":Landroid/net/NetworkInfo;
    if-eqz v1, :cond_49

    invoke-virtual {v1}, Landroid/net/NetworkInfo;->isConnectedOrConnecting()Z

    move-result v4

    if-eqz v4, :cond_49

    .line 84
    invoke-static {p1}, Lorg/adaway/helper/PreferenceHelper;->getUpdateOnlyOnWifi(Landroid/content/Context;)Z

    move-result v3

    .line 87
    .local v3, "updateOnlyOnWifi":Z
    invoke-virtual {v1}, Landroid/net/NetworkInfo;->getType()I

    move-result v4

    if-nez v4, :cond_21

    if-eqz v3, :cond_27

    :cond_21
    invoke-virtual {v1}, Landroid/net/NetworkInfo;->getType()I

    move-result v4

    if-ne v4, v6, :cond_3e

    .line 89
    :cond_27
    const-string v4, "AdAway"

    const-string v5, "We have internet, start update check directly now!"

    invoke-static {v4, v5}, Lorg/adaway/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 91
    new-instance v2, Landroid/content/Intent;

    const-class v4, Lorg/adaway/service/UpdateService;

    invoke-direct {v2, p1, v4}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 92
    .local v2, "updateIntent":Landroid/content/Intent;
    const-string v4, "org.adaway.BACKGROUND_EXECUTION"

    invoke-virtual {v2, v4, v6}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    .line 93
    invoke-static {p1, v2}, Lcom/commonsware/cwac/wakeful/WakefulIntentService;->sendWakefulWork(Landroid/content/Context;Landroid/content/Intent;)V

    .line 106
    .end local v2    # "updateIntent":Landroid/content/Intent;
    .end local v3    # "updateOnlyOnWifi":Z
    :goto_3d
    return-void

    .line 95
    .restart local v3    # "updateOnlyOnWifi":Z
    :cond_3e
    const-string v4, "AdAway"

    const-string v5, "We have no internet, enable ConnectivityReceiver!"

    invoke-static {v4, v5}, Lorg/adaway/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 98
    invoke-static {p1}, Lorg/adaway/service/ConnectivityReceiver;->enableReceiver(Landroid/content/Context;)V

    goto :goto_3d

    .line 101
    .end local v3    # "updateOnlyOnWifi":Z
    :cond_49
    const-string v4, "AdAway"

    const-string v5, "We have no internet, enable ConnectivityReceiver!"

    invoke-static {v4, v5}, Lorg/adaway/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 104
    invoke-static {p1}, Lorg/adaway/service/ConnectivityReceiver;->enableReceiver(Landroid/content/Context;)V

    goto :goto_3d
.end method
