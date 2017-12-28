.class public Lorg/pornaway/service/ConnectivityReceiver;
.super Landroid/content/BroadcastReceiver;
.source "ConnectivityReceiver.java"


# direct methods
.method public constructor <init>()V
    .registers 1

    .prologue
    .line 37
    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    return-void
.end method

.method public static disableReceiver(Landroid/content/Context;)V
    .registers 5
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 100
    new-instance v0, Landroid/content/ComponentName;

    const-class v1, Lorg/pornaway/service/ConnectivityReceiver;

    invoke-direct {v0, p0, v1}, Landroid/content/ComponentName;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 102
    .local v0, "component":Landroid/content/ComponentName;
    invoke-virtual {p0}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v1

    const/4 v2, 0x2

    const/4 v3, 0x1

    invoke-virtual {v1, v0, v2, v3}, Landroid/content/pm/PackageManager;->setComponentEnabledSetting(Landroid/content/ComponentName;II)V

    .line 104
    return-void
.end method

.method public static enableReceiver(Landroid/content/Context;)V
    .registers 4
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    const/4 v2, 0x1

    .line 88
    new-instance v0, Landroid/content/ComponentName;

    const-class v1, Lorg/pornaway/service/ConnectivityReceiver;

    invoke-direct {v0, p0, v1}, Landroid/content/ComponentName;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 90
    .local v0, "component":Landroid/content/ComponentName;
    invoke-virtual {p0}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v1

    invoke-virtual {v1, v0, v2, v2}, Landroid/content/pm/PackageManager;->setComponentEnabledSetting(Landroid/content/ComponentName;II)V

    .line 92
    return-void
.end method


# virtual methods
.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .registers 11
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "intent"    # Landroid/content/Intent;

    .prologue
    const/4 v7, 0x1

    .line 41
    invoke-virtual {p2}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v5

    const-string v6, "android.net.conn.CONNECTIVITY_CHANGE"

    invoke-virtual {v5, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_71

    .line 42
    const-string v5, "PornAway"

    const-string v6, "ConnectivityReceiver invoked..."

    invoke-static {v5, v6}, Lorg/pornaway/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 45
    invoke-static {p1}, Lorg/pornaway/helper/PreferenceHelper;->getUpdateCheckDaily(Landroid/content/Context;)Z

    move-result v5

    if-eqz v5, :cond_71

    .line 46
    const-string v5, "PornAway"

    const-string v6, "Update check daily is enabled!"

    invoke-static {v5, v6}, Lorg/pornaway/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 48
    const-string v5, "noConnectivity"

    const/4 v6, 0x0

    invoke-virtual {p2, v5, v6}, Landroid/content/Intent;->getBooleanExtra(Ljava/lang/String;Z)Z

    move-result v2

    .line 51
    .local v2, "noConnectivity":Z
    if-nez v2, :cond_71

    .line 53
    const-string v5, "connectivity"

    .line 54
    invoke-virtual {p1, v5}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/net/ConnectivityManager;

    .line 55
    .local v0, "cm":Landroid/net/ConnectivityManager;
    invoke-virtual {v0}, Landroid/net/ConnectivityManager;->getActiveNetworkInfo()Landroid/net/NetworkInfo;

    move-result-object v1

    .line 58
    .local v1, "netInfo":Landroid/net/NetworkInfo;
    if-eqz v1, :cond_71

    invoke-virtual {v1}, Landroid/net/NetworkInfo;->isConnectedOrConnecting()Z

    move-result v5

    if-eqz v5, :cond_71

    .line 60
    invoke-static {p1}, Lorg/pornaway/helper/PreferenceHelper;->getUpdateOnlyOnWifi(Landroid/content/Context;)Z

    move-result v4

    .line 63
    .local v4, "updateOnlyOnWifi":Z
    invoke-virtual {v1}, Landroid/net/NetworkInfo;->getType()I

    move-result v5

    if-nez v5, :cond_4a

    if-eqz v4, :cond_58

    .line 64
    :cond_4a
    invoke-virtual {v1}, Landroid/net/NetworkInfo;->getType()I

    move-result v5

    if-eq v5, v7, :cond_58

    .line 65
    invoke-virtual {v1}, Landroid/net/NetworkInfo;->getType()I

    move-result v5

    const/16 v6, 0x9

    if-ne v5, v6, :cond_71

    .line 66
    :cond_58
    const-string v5, "PornAway"

    const-string v6, "We have internet, start update check and disable receiver!"

    invoke-static {v5, v6}, Lorg/pornaway/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 69
    new-instance v3, Landroid/content/Intent;

    const-class v5, Lorg/pornaway/service/UpdateService;

    invoke-direct {v3, p1, v5}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 70
    .local v3, "updateIntent":Landroid/content/Intent;
    const-string v5, "org.pornaway.BACKGROUND_EXECUTION"

    invoke-virtual {v3, v5, v7}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    .line 71
    invoke-static {p1, v3}, Lcom/commonsware/cwac/wakeful/WakefulIntentService;->sendWakefulWork(Landroid/content/Context;Landroid/content/Intent;)V

    .line 74
    invoke-static {p1}, Lorg/pornaway/service/ConnectivityReceiver;->disableReceiver(Landroid/content/Context;)V

    .line 80
    .end local v0    # "cm":Landroid/net/ConnectivityManager;
    .end local v1    # "netInfo":Landroid/net/NetworkInfo;
    .end local v2    # "noConnectivity":Z
    .end local v3    # "updateIntent":Landroid/content/Intent;
    .end local v4    # "updateOnlyOnWifi":Z
    :cond_71
    return-void
.end method
