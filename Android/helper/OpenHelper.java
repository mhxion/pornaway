.class public Lorg/pornaway/helper/OpenHelper;
.super Ljava/lang/Object;
.source "OpenHelper.java"


# direct methods
.method public constructor <init>()V
    .registers 1

    .prologue
    .line 35
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private static openFileWithEditor(Landroid/support/v4/app/FragmentActivity;Ljava/lang/String;)V
    .registers 10
    .param p0, "activity"    # Landroid/support/v4/app/FragmentActivity;
    .param p1, "file"    # Ljava/lang/String;

    .prologue
    .line 67
    new-instance v1, Landroid/content/Intent;

    invoke-direct {v1}, Landroid/content/Intent;-><init>()V

    .line 68
    .local v1, "intent":Landroid/content/Intent;
    const-string v4, "android.intent.action.VIEW"

    invoke-virtual {v1, v4}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 69
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "file://"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v3

    .line 70
    .local v3, "uri":Landroid/net/Uri;
    const-string v4, "text/plain"

    invoke-virtual {v1, v3, v4}, Landroid/content/Intent;->setDataAndType(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/Intent;

    .line 73
    :try_start_26
    invoke-virtual {p0, v1}, Landroid/support/v4/app/FragmentActivity;->startActivity(Landroid/content/Intent;)V
    :try_end_29
    .catch Landroid/content/ActivityNotFoundException; {:try_start_26 .. :try_end_29} :catch_2a

    .line 81
    :goto_29
    return-void

    .line 74
    :catch_2a
    move-exception v0

    .line 75
    .local v0, "e":Landroid/content/ActivityNotFoundException;
    const v4, 0x7f080063

    const v5, 0x7f0800ab

    const-string v6, "market://details?id=jp.sblo.pandora.jota"

    const-string v7, "Text Edit"

    .line 76
    invoke-static {v4, v5, v6, v7}, Lorg/pornaway/ui/dialog/ActivityNotFoundDialogFragment;->newInstance(IILjava/lang/String;Ljava/lang/String;)Lorg/pornaway/ui/dialog/ActivityNotFoundDialogFragment;

    move-result-object v2

    .line 79
    .local v2, "notFoundDialog":Lorg/pornaway/ui/dialog/ActivityNotFoundDialogFragment;
    invoke-virtual {p0}, Landroid/support/v4/app/FragmentActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v4

    const-string v5, "notFoundDialog"

    invoke-virtual {v2, v4, v5}, Lorg/pornaway/ui/dialog/ActivityNotFoundDialogFragment;->show(Landroid/support/v4/app/FragmentManager;Ljava/lang/String;)V

    goto :goto_29
.end method

.method public static openHostsFile(Landroid/support/v4/app/FragmentActivity;)V
    .registers 6
    .param p0, "activity"    # Landroid/support/v4/app/FragmentActivity;

    .prologue
    .line 44
    :try_start_0
    invoke-static {}, Lorg/sufficientlysecure/rootcommands/Shell;->startRootShell()Lorg/sufficientlysecure/rootcommands/Shell;

    move-result-object v1

    .line 46
    .local v1, "rootShell":Lorg/sufficientlysecure/rootcommands/Shell;
    new-instance v2, Lorg/sufficientlysecure/rootcommands/Toolbox;

    invoke-direct {v2, v1}, Lorg/sufficientlysecure/rootcommands/Toolbox;-><init>(Lorg/sufficientlysecure/rootcommands/Shell;)V

    .line 48
    .local v2, "tb":Lorg/sufficientlysecure/rootcommands/Toolbox;
    sget-object v3, Lorg/pornaway/util/Constants;->ANDROID_SYSTEM_ETC_HOSTS:Ljava/lang/String;

    const-string v4, "RW"

    invoke-virtual {v2, v3, v4}, Lorg/sufficientlysecure/rootcommands/Toolbox;->remount(Ljava/lang/String;Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_1c

    .line 49
    sget-object v3, Lorg/pornaway/util/Constants;->ANDROID_SYSTEM_ETC_HOSTS:Ljava/lang/String;

    invoke-static {p0, v3}, Lorg/pornaway/helper/OpenHelper;->openFileWithEditor(Landroid/support/v4/app/FragmentActivity;Ljava/lang/String;)V

    .line 54
    :goto_18
    invoke-virtual {v1}, Lorg/sufficientlysecure/rootcommands/Shell;->close()V

    .line 58
    .end local v1    # "rootShell":Lorg/sufficientlysecure/rootcommands/Shell;
    .end local v2    # "tb":Lorg/sufficientlysecure/rootcommands/Toolbox;
    :goto_1b
    return-void

    .line 51
    .restart local v1    # "rootShell":Lorg/sufficientlysecure/rootcommands/Shell;
    .restart local v2    # "tb":Lorg/sufficientlysecure/rootcommands/Toolbox;
    :cond_1c
    const-string v3, "PornAway"

    const-string v4, "System partition could not be remounted as rw!"

    invoke-static {v3, v4}, Lorg/pornaway/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_23
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_23} :catch_24

    goto :goto_18

    .line 55
    .end local v1    # "rootShell":Lorg/sufficientlysecure/rootcommands/Shell;
    .end local v2    # "tb":Lorg/sufficientlysecure/rootcommands/Toolbox;
    :catch_24
    move-exception v0

    .line 56
    .local v0, "e":Ljava/lang/Exception;
    const-string v3, "PornAway"

    const-string v4, "Problem with root shell!"

    invoke-static {v3, v4, v0}, Lorg/pornaway/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_1b
.end method
