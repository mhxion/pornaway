.class public Lorg/pornaway/service/RevertService;
.super Lcom/commonsware/cwac/wakeful/WakefulIntentService;
.source "RevertService.java"


# instance fields
.field private mService:Landroid/content/Context;


# direct methods
.method public constructor <init>()V
    .registers 2

    .prologue
    .line 44
    const-string v0, "PornAwayRevertService"

    invoke-direct {p0, v0}, Lcom/commonsware/cwac/wakeful/WakefulIntentService;-><init>(Ljava/lang/String;)V

    .line 45
    return-void
.end method

.method private revert(Lorg/sufficientlysecure/rootcommands/Shell;)I
    .registers 9
    .param p1, "shell"    # Lorg/sufficientlysecure/rootcommands/Shell;

    .prologue
    const/4 v6, 0x0

    .line 84
    iget-object v3, p0, Lorg/pornaway/service/RevertService;->mService:Landroid/content/Context;

    const v4, 0x7f080095

    invoke-virtual {p0, v4}, Lorg/pornaway/service/RevertService;->getString(I)Ljava/lang/String;

    move-result-object v4

    const v5, 0x7f080096

    .line 85
    invoke-virtual {p0, v5}, Lorg/pornaway/service/RevertService;->getString(I)Ljava/lang/String;

    move-result-object v5

    .line 84
    invoke-static {v3, v4, v5, v6}, Lorg/pornaway/ui/BaseActivity;->setStatusBroadcast(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;I)V

    .line 89
    :try_start_14
    iget-object v3, p0, Lorg/pornaway/service/RevertService;->mService:Landroid/content/Context;

    const-string v4, "hosts"

    const/4 v5, 0x0

    invoke-virtual {v3, v4, v5}, Landroid/content/Context;->openFileOutput(Ljava/lang/String;I)Ljava/io/FileOutputStream;

    move-result-object v1

    .line 93
    .local v1, "fos":Ljava/io/FileOutputStream;
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "127.0.0.1 localhost"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    sget-object v4, Lorg/pornaway/util/Constants;->LINE_SEPERATOR:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "::1"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "localhost"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 96
    .local v2, "localhost":Ljava/lang/String;
    invoke-virtual {v2}, Ljava/lang/String;->getBytes()[B

    move-result-object v3

    invoke-virtual {v1, v3}, Ljava/io/FileOutputStream;->write([B)V

    .line 97
    invoke-virtual {v1}, Ljava/io/FileOutputStream;->close()V

    .line 100
    iget-object v3, p0, Lorg/pornaway/service/RevertService;->mService:Landroid/content/Context;

    invoke-static {v3}, Lorg/pornaway/helper/PreferenceHelper;->getApplyMethod(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v3

    const-string v4, "writeToSystem"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_72

    .line 102
    iget-object v3, p0, Lorg/pornaway/service/RevertService;->mService:Landroid/content/Context;

    sget-object v4, Lorg/pornaway/util/Constants;->ANDROID_SYSTEM_ETC_HOSTS:Ljava/lang/String;

    invoke-static {v3, v4, p1}, Lorg/pornaway/util/ApplyUtils;->copyHostsFile(Landroid/content/Context;Ljava/lang/String;Lorg/sufficientlysecure/rootcommands/Shell;)V

    .line 116
    :cond_63
    :goto_63
    iget-object v3, p0, Lorg/pornaway/service/RevertService;->mService:Landroid/content/Context;

    const-string v4, "hosts"

    invoke-virtual {v3, v4}, Landroid/content/Context;->deleteFile(Ljava/lang/String;)Z

    .line 119
    iget-object v3, p0, Lorg/pornaway/service/RevertService;->mService:Landroid/content/Context;

    invoke-static {v3}, Lorg/pornaway/ui/BaseActivity;->updateStatusDisabled(Landroid/content/Context;)V

    .line 121
    const/16 v3, 0xe

    .line 125
    .end local v1    # "fos":Ljava/io/FileOutputStream;
    .end local v2    # "localhost":Ljava/lang/String;
    :goto_71
    return v3

    .line 103
    .restart local v1    # "fos":Ljava/io/FileOutputStream;
    .restart local v2    # "localhost":Ljava/lang/String;
    :cond_72
    iget-object v3, p0, Lorg/pornaway/service/RevertService;->mService:Landroid/content/Context;

    invoke-static {v3}, Lorg/pornaway/helper/PreferenceHelper;->getApplyMethod(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v3

    const-string v4, "writeToDataData"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_93

    .line 105
    iget-object v3, p0, Lorg/pornaway/service/RevertService;->mService:Landroid/content/Context;

    sget-object v4, Lorg/pornaway/util/Constants;->ANDROID_DATA_DATA_HOSTS:Ljava/lang/String;

    invoke-static {v3, v4, p1}, Lorg/pornaway/util/ApplyUtils;->copyHostsFile(Landroid/content/Context;Ljava/lang/String;Lorg/sufficientlysecure/rootcommands/Shell;)V
    :try_end_87
    .catch Ljava/lang/Exception; {:try_start_14 .. :try_end_87} :catch_88

    goto :goto_63

    .line 122
    .end local v1    # "fos":Ljava/io/FileOutputStream;
    .end local v2    # "localhost":Ljava/lang/String;
    :catch_88
    move-exception v0

    .line 123
    .local v0, "e":Ljava/lang/Exception;
    const-string v3, "PornAway"

    const-string v4, "Exception"

    invoke-static {v3, v4, v0}, Lorg/pornaway/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 125
    const/16 v3, 0xf

    goto :goto_71

    .line 106
    .end local v0    # "e":Ljava/lang/Exception;
    .restart local v1    # "fos":Ljava/io/FileOutputStream;
    .restart local v2    # "localhost":Ljava/lang/String;
    :cond_93
    :try_start_93
    iget-object v3, p0, Lorg/pornaway/service/RevertService;->mService:Landroid/content/Context;

    invoke-static {v3}, Lorg/pornaway/helper/PreferenceHelper;->getApplyMethod(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v3

    const-string v4, "writeToData"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_a9

    .line 108
    iget-object v3, p0, Lorg/pornaway/service/RevertService;->mService:Landroid/content/Context;

    sget-object v4, Lorg/pornaway/util/Constants;->ANDROID_DATA_HOSTS:Ljava/lang/String;

    invoke-static {v3, v4, p1}, Lorg/pornaway/util/ApplyUtils;->copyHostsFile(Landroid/content/Context;Ljava/lang/String;Lorg/sufficientlysecure/rootcommands/Shell;)V

    goto :goto_63

    .line 109
    :cond_a9
    iget-object v3, p0, Lorg/pornaway/service/RevertService;->mService:Landroid/content/Context;

    invoke-static {v3}, Lorg/pornaway/helper/PreferenceHelper;->getApplyMethod(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v3

    const-string v4, "customTarget"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_63

    .line 111
    iget-object v3, p0, Lorg/pornaway/service/RevertService;->mService:Landroid/content/Context;

    iget-object v4, p0, Lorg/pornaway/service/RevertService;->mService:Landroid/content/Context;

    invoke-static {v4}, Lorg/pornaway/helper/PreferenceHelper;->getCustomTarget(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4, p1}, Lorg/pornaway/util/ApplyUtils;->copyHostsFile(Landroid/content/Context;Ljava/lang/String;Lorg/sufficientlysecure/rootcommands/Shell;)V
    :try_end_c2
    .catch Ljava/lang/Exception; {:try_start_93 .. :try_end_c2} :catch_88

    goto :goto_63
.end method


# virtual methods
.method public doWakefulWork(Landroid/content/Intent;)V
    .registers 8
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    .line 60
    iget-object v3, p0, Lorg/pornaway/service/RevertService;->mService:Landroid/content/Context;

    const/4 v4, 0x1

    invoke-static {v3, v4}, Lorg/pornaway/ui/BaseActivity;->setButtonsDisabledBroadcast(Landroid/content/Context;Z)V

    .line 63
    :try_start_6
    invoke-static {}, Lorg/sufficientlysecure/rootcommands/Shell;->startRootShell()Lorg/sufficientlysecure/rootcommands/Shell;

    move-result-object v2

    .line 64
    .local v2, "rootShell":Lorg/sufficientlysecure/rootcommands/Shell;
    invoke-direct {p0, v2}, Lorg/pornaway/service/RevertService;->revert(Lorg/sufficientlysecure/rootcommands/Shell;)I

    move-result v1

    .line 65
    .local v1, "revertResult":I
    invoke-virtual {v2}, Lorg/sufficientlysecure/rootcommands/Shell;->close()V

    .line 67
    const-string v3, "PornAway"

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "revert result: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Lorg/pornaway/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 70
    iget-object v3, p0, Lorg/pornaway/service/RevertService;->mService:Landroid/content/Context;

    const/4 v4, 0x0

    invoke-static {v3, v4}, Lorg/pornaway/ui/BaseActivity;->setButtonsDisabledBroadcast(Landroid/content/Context;Z)V

    .line 72
    iget-object v3, p0, Lorg/pornaway/service/RevertService;->mService:Landroid/content/Context;

    const/4 v4, 0x0

    invoke-static {v3, v1, v4}, Lorg/pornaway/helper/ResultHelper;->showNotificationBasedOnResult(Landroid/content/Context;ILjava/lang/String;)V
    :try_end_35
    .catch Ljava/lang/Exception; {:try_start_6 .. :try_end_35} :catch_36

    .line 76
    .end local v1    # "revertResult":I
    .end local v2    # "rootShell":Lorg/sufficientlysecure/rootcommands/Shell;
    :goto_35
    return-void

    .line 73
    :catch_36
    move-exception v0

    .line 74
    .local v0, "e":Ljava/lang/Exception;
    const-string v3, "PornAway"

    const-string v4, "Problem while reverting!"

    invoke-static {v3, v4, v0}, Lorg/pornaway/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_35
.end method

.method public onStartCommand(Landroid/content/Intent;II)I
    .registers 5
    .param p1, "intent"    # Landroid/content/Intent;
    .param p2, "flags"    # I
    .param p3, "startId"    # I

    .prologue
    .line 49
    iput-object p0, p0, Lorg/pornaway/service/RevertService;->mService:Landroid/content/Context;

    .line 51
    invoke-super {p0, p1, p2, p3}, Lcom/commonsware/cwac/wakeful/WakefulIntentService;->onStartCommand(Landroid/content/Intent;II)I

    move-result v0

    return v0
.end method
