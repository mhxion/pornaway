.class public Lorg/pornaway/service/BootService;
.super Landroid/app/IntentService;
.source "BootService.java"


# direct methods
.method public constructor <init>()V
    .registers 2

    .prologue
    .line 33
    const-string v0, "PornAwayBootService"

    invoke-direct {p0, v0}, Landroid/app/IntentService;-><init>(Ljava/lang/String;)V

    .line 34
    return-void
.end method


# virtual methods
.method protected onHandleIntent(Landroid/content/Intent;)V
    .registers 4
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    .line 39
    const-string v0, "PornAway"

    const-string v1, "BootService: onHandleIntent"

    invoke-static {v0, v1}, Lorg/pornaway/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 40
    invoke-virtual {p0}, Lorg/pornaway/service/BootService;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lorg/pornaway/util/WebserverUtils;->startWebserverOnBoot(Landroid/content/Context;)V

    .line 41
    return-void
.end method
