.class public Lorg/pornaway/util/WebserverUtils;
.super Ljava/lang/Object;
.source "WebserverUtils.java"


# direct methods
.method public constructor <init>()V
    .registers 1

    .prologue
    .line 30
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static isWebserverRunning(Lorg/sufficientlysecure/rootcommands/Shell;)Z
    .registers 6
    .param p0, "shell"    # Lorg/sufficientlysecure/rootcommands/Shell;

    .prologue
    const/4 v2, 0x0

    .line 89
    :try_start_1
    new-instance v1, Lorg/sufficientlysecure/rootcommands/Toolbox;

    invoke-direct {v1, p0}, Lorg/sufficientlysecure/rootcommands/Toolbox;-><init>(Lorg/sufficientlysecure/rootcommands/Shell;)V

    .line 91
    .local v1, "tb":Lorg/sufficientlysecure/rootcommands/Toolbox;
    const-string v3, "blank_webserver"

    invoke-virtual {v1, v3}, Lorg/sufficientlysecure/rootcommands/Toolbox;->isBinaryRunning(Ljava/lang/String;)Z
    :try_end_b
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_b} :catch_10

    move-result v3

    if-eqz v3, :cond_f

    .line 92
    const/4 v2, 0x1

    .line 98
    .end local v1    # "tb":Lorg/sufficientlysecure/rootcommands/Toolbox;
    :cond_f
    :goto_f
    return v2

    .line 96
    :catch_10
    move-exception v0

    .line 97
    .local v0, "e":Ljava/lang/Exception;
    const-string v3, "PornAway"

    const-string v4, "Exception while checking webserver process"

    invoke-static {v3, v4, v0}, Lorg/pornaway/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_f
.end method

.method public static startWebserver(Landroid/content/Context;Lorg/sufficientlysecure/rootcommands/Shell;)V
    .registers 6
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "shell"    # Lorg/sufficientlysecure/rootcommands/Shell;

    .prologue
    .line 38
    const-string v2, "PornAway"

    const-string v3, "Starting webserver..."

    invoke-static {v2, v3}, Lorg/pornaway/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 41
    :try_start_7
    new-instance v1, Lorg/sufficientlysecure/rootcommands/command/SimpleExecutableCommand;

    const-string v2, "blank_webserver"

    const-string v3, " > /dev/null 2>&1 &"

    invoke-direct {v1, p0, v2, v3}, Lorg/sufficientlysecure/rootcommands/command/SimpleExecutableCommand;-><init>(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    .line 44
    .local v1, "webserverCommand":Lorg/sufficientlysecure/rootcommands/command/SimpleExecutableCommand;
    invoke-virtual {p1, v1}, Lorg/sufficientlysecure/rootcommands/Shell;->add(Lorg/sufficientlysecure/rootcommands/command/Command;)Lorg/sufficientlysecure/rootcommands/command/Command;

    move-result-object v2

    invoke-virtual {v2}, Lorg/sufficientlysecure/rootcommands/command/Command;->waitForFinish()V
    :try_end_17
    .catch Ljava/lang/Exception; {:try_start_7 .. :try_end_17} :catch_18

    .line 48
    .end local v1    # "webserverCommand":Lorg/sufficientlysecure/rootcommands/command/SimpleExecutableCommand;
    :goto_17
    return-void

    .line 45
    :catch_18
    move-exception v0

    .line 46
    .local v0, "e":Ljava/lang/Exception;
    const-string v2, "PornAway"

    const-string v3, "Exception while starting webserver"

    invoke-static {v2, v3, v0}, Lorg/pornaway/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_17
.end method

.method public static startWebserverOnBoot(Landroid/content/Context;)V
    .registers 5
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 57
    invoke-static {p0}, Lorg/pornaway/helper/PreferenceHelper;->getWebserverOnBoot(Landroid/content/Context;)Z

    move-result v2

    if-eqz v2, :cond_10

    .line 59
    :try_start_6
    invoke-static {}, Lorg/sufficientlysecure/rootcommands/Shell;->startRootShell()Lorg/sufficientlysecure/rootcommands/Shell;

    move-result-object v1

    .line 60
    .local v1, "rootShell":Lorg/sufficientlysecure/rootcommands/Shell;
    invoke-static {p0, v1}, Lorg/pornaway/util/WebserverUtils;->startWebserver(Landroid/content/Context;Lorg/sufficientlysecure/rootcommands/Shell;)V

    .line 61
    invoke-virtual {v1}, Lorg/sufficientlysecure/rootcommands/Shell;->close()V
    :try_end_10
    .catch Ljava/lang/Exception; {:try_start_6 .. :try_end_10} :catch_11

    .line 66
    .end local v1    # "rootShell":Lorg/sufficientlysecure/rootcommands/Shell;
    :cond_10
    :goto_10
    return-void

    .line 62
    :catch_11
    move-exception v0

    .line 63
    .local v0, "e":Ljava/lang/Exception;
    const-string v2, "PornAway"

    const-string v3, "Problem while starting webserver on boot!"

    invoke-static {v2, v3, v0}, Lorg/pornaway/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_10
.end method

.method public static stopWebserver(Landroid/content/Context;Lorg/sufficientlysecure/rootcommands/Shell;)V
    .registers 6
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "shell"    # Lorg/sufficientlysecure/rootcommands/Shell;

    .prologue
    .line 75
    :try_start_0
    new-instance v1, Lorg/sufficientlysecure/rootcommands/Toolbox;

    invoke-direct {v1, p1}, Lorg/sufficientlysecure/rootcommands/Toolbox;-><init>(Lorg/sufficientlysecure/rootcommands/Shell;)V

    .line 76
    .local v1, "tb":Lorg/sufficientlysecure/rootcommands/Toolbox;
    const-string v2, "blank_webserver"

    invoke-virtual {v1, v2}, Lorg/sufficientlysecure/rootcommands/Toolbox;->killAllExecutable(Ljava/lang/String;)Z
    :try_end_a
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_a} :catch_b

    .line 80
    .end local v1    # "tb":Lorg/sufficientlysecure/rootcommands/Toolbox;
    :goto_a
    return-void

    .line 77
    :catch_b
    move-exception v0

    .line 78
    .local v0, "e":Ljava/lang/Exception;
    const-string v2, "PornAway"

    const-string v3, "Exception while killing webserver"

    invoke-static {v2, v3, v0}, Lorg/pornaway/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_a
.end method
