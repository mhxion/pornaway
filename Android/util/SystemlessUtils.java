.class public Lorg/pornaway/util/SystemlessUtils;
.super Ljava/lang/Object;
.source "SystemlessUtils.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lorg/pornaway/util/SystemlessUtils$SystemlessModeStatus;
    }
.end annotation


# direct methods
.method public constructor <init>()V
    .registers 1

    .prologue
    .line 18
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static disableSystemlessMode(Lorg/sufficientlysecure/rootcommands/Shell;)Z
    .registers 11
    .param p0, "shell"    # Lorg/sufficientlysecure/rootcommands/Shell;

    .prologue
    const/4 v4, 0x1

    const/4 v5, 0x0

    .line 136
    :try_start_2
    invoke-static {p0}, Lorg/pornaway/util/SystemlessUtils;->isSystemlessModeEnabled(Lorg/sufficientlysecure/rootcommands/Shell;)Z

    move-result v6

    if-nez v6, :cond_9

    .line 158
    :goto_8
    return v4

    .line 140
    :cond_9
    new-instance v2, Lorg/sufficientlysecure/rootcommands/command/SimpleCommand;

    const/4 v6, 0x1

    new-array v6, v6, [Ljava/lang/String;

    const/4 v7, 0x0

    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    const-string v9, "rm -f "

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    sget-object v9, Lorg/pornaway/util/Constants;->ANDROID_SYSTEMLESS_SCRIPT:Ljava/lang/String;

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    aput-object v8, v6, v7

    invoke-direct {v2, v6}, Lorg/sufficientlysecure/rootcommands/command/SimpleCommand;-><init>([Ljava/lang/String;)V

    .line 142
    .local v2, "removeScriptCommand":Lorg/sufficientlysecure/rootcommands/command/SimpleCommand;
    invoke-virtual {p0, v2}, Lorg/sufficientlysecure/rootcommands/Shell;->add(Lorg/sufficientlysecure/rootcommands/command/Command;)Lorg/sufficientlysecure/rootcommands/command/Command;

    move-result-object v6

    invoke-virtual {v6}, Lorg/sufficientlysecure/rootcommands/command/Command;->waitForFinish()V

    .line 143
    invoke-virtual {v2}, Lorg/sufficientlysecure/rootcommands/command/SimpleCommand;->getExitCode()I

    move-result v6

    if-eqz v6, :cond_3f

    .line 144
    const-string v4, "PornAway"

    const-string v6, "Couldn\'t remove systemless script."

    invoke-static {v4, v6}, Lorg/pornaway/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    move v4, v5

    .line 145
    goto :goto_8

    .line 148
    :cond_3f
    new-instance v3, Lorg/sufficientlysecure/rootcommands/command/SimpleCommand;

    const/4 v6, 0x1

    new-array v6, v6, [Ljava/lang/String;

    const/4 v7, 0x0

    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    const-string v9, "umount "

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    sget-object v9, Lorg/pornaway/util/Constants;->ANDROID_SYSTEM_ETC_HOSTS:Ljava/lang/String;

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    aput-object v8, v6, v7

    invoke-direct {v3, v6}, Lorg/sufficientlysecure/rootcommands/command/SimpleCommand;-><init>([Ljava/lang/String;)V

    .line 150
    .local v3, "umountCommand":Lorg/sufficientlysecure/rootcommands/command/SimpleCommand;
    invoke-virtual {p0, v3}, Lorg/sufficientlysecure/rootcommands/Shell;->add(Lorg/sufficientlysecure/rootcommands/command/Command;)Lorg/sufficientlysecure/rootcommands/command/Command;

    move-result-object v6

    invoke-virtual {v6}, Lorg/sufficientlysecure/rootcommands/command/Command;->waitForFinish()V

    .line 152
    new-instance v1, Lorg/sufficientlysecure/rootcommands/command/SimpleCommand;

    const/4 v6, 0x1

    new-array v6, v6, [Ljava/lang/String;

    const/4 v7, 0x0

    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    const-string v9, "rm -f "

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    sget-object v9, Lorg/pornaway/util/Constants;->ANDROID_SU_ETC_HOSTS:Ljava/lang/String;

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    aput-object v8, v6, v7

    invoke-direct {v1, v6}, Lorg/sufficientlysecure/rootcommands/command/SimpleCommand;-><init>([Ljava/lang/String;)V

    .line 154
    .local v1, "removeMountedHostsCommand":Lorg/sufficientlysecure/rootcommands/command/SimpleCommand;
    invoke-virtual {p0, v1}, Lorg/sufficientlysecure/rootcommands/Shell;->add(Lorg/sufficientlysecure/rootcommands/command/Command;)Lorg/sufficientlysecure/rootcommands/command/Command;

    move-result-object v6

    invoke-virtual {v6}, Lorg/sufficientlysecure/rootcommands/command/Command;->waitForFinish()V
    :try_end_8d
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_8d} :catch_8f

    goto/16 :goto_8

    .line 156
    .end local v1    # "removeMountedHostsCommand":Lorg/sufficientlysecure/rootcommands/command/SimpleCommand;
    .end local v2    # "removeScriptCommand":Lorg/sufficientlysecure/rootcommands/command/SimpleCommand;
    .end local v3    # "umountCommand":Lorg/sufficientlysecure/rootcommands/command/SimpleCommand;
    :catch_8f
    move-exception v0

    .line 157
    .local v0, "exception":Ljava/lang/Exception;
    const-string v4, "PornAway"

    const-string v6, "Error while disabling systemless mode."

    invoke-static {v4, v6, v0}, Lorg/pornaway/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    move v4, v5

    .line 158
    goto/16 :goto_8
.end method

.method public static enableSystemlessMode(Landroid/content/Context;Lorg/sufficientlysecure/rootcommands/Shell;)Z
    .registers 14
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "shell"    # Lorg/sufficientlysecure/rootcommands/Shell;

    .prologue
    const/4 v6, 0x1

    const/4 v7, 0x0

    .line 70
    :try_start_2
    new-instance v4, Lorg/sufficientlysecure/rootcommands/Toolbox;

    invoke-direct {v4, p1}, Lorg/sufficientlysecure/rootcommands/Toolbox;-><init>(Lorg/sufficientlysecure/rootcommands/Shell;)V

    .line 72
    .local v4, "toolbox":Lorg/sufficientlysecure/rootcommands/Toolbox;
    sget-object v8, Lorg/pornaway/util/Constants;->ANDROID_SU_ETC_HOSTS:Ljava/lang/String;

    invoke-virtual {v4, v8}, Lorg/sufficientlysecure/rootcommands/Toolbox;->fileExists(Ljava/lang/String;)Z

    move-result v8

    if-nez v8, :cond_18

    .line 74
    sget-object v8, Lorg/pornaway/util/Constants;->ANDROID_SYSTEM_ETC_HOSTS:Ljava/lang/String;

    sget-object v9, Lorg/pornaway/util/Constants;->ANDROID_SU_ETC_HOSTS:Ljava/lang/String;

    const/4 v10, 0x0

    const/4 v11, 0x1

    invoke-virtual {v4, v8, v9, v10, v11}, Lorg/sufficientlysecure/rootcommands/Toolbox;->copyFile(Ljava/lang/String;Ljava/lang/String;ZZ)Z

    .line 77
    :cond_18
    invoke-static {p1}, Lorg/pornaway/util/SystemlessUtils;->isSystemlessModeEnabled(Lorg/sufficientlysecure/rootcommands/Shell;)Z

    move-result v8

    if-eqz v8, :cond_1f

    .line 121
    .end local v4    # "toolbox":Lorg/sufficientlysecure/rootcommands/Toolbox;
    :cond_1e
    :goto_1e
    return v6

    .line 84
    .restart local v4    # "toolbox":Lorg/sufficientlysecure/rootcommands/Toolbox;
    :cond_1f
    invoke-virtual {p0}, Landroid/content/Context;->getCacheDir()Ljava/io/File;

    move-result-object v0

    .line 85
    .local v0, "cacheDir":Ljava/io/File;
    const-string v8, "PornAway"

    const-string v9, ".script"

    invoke-static {v8, v9, v0}, Ljava/io/File;->createTempFile(Ljava/lang/String;Ljava/lang/String;Ljava/io/File;)Ljava/io/File;

    move-result-object v3

    .line 87
    .local v3, "tempFile":Ljava/io/File;
    new-instance v5, Ljava/io/BufferedWriter;

    new-instance v8, Ljava/io/FileWriter;

    invoke-direct {v8, v3}, Ljava/io/FileWriter;-><init>(Ljava/io/File;)V

    invoke-direct {v5, v8}, Ljava/io/BufferedWriter;-><init>(Ljava/io/Writer;)V

    .line 88
    .local v5, "writer":Ljava/io/BufferedWriter;
    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    const-string v9, "mount -o bind "

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    sget-object v9, Lorg/pornaway/util/Constants;->ANDROID_SU_ETC_HOSTS:Ljava/lang/String;

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    const-string v9, " "

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    sget-object v9, Lorg/pornaway/util/Constants;->ANDROID_SYSTEM_ETC_HOSTS:Ljava/lang/String;

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    const-string v9, ";"

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v5, v8}, Ljava/io/BufferedWriter;->write(Ljava/lang/String;)V

    .line 89
    invoke-virtual {v5}, Ljava/io/BufferedWriter;->newLine()V

    .line 90
    invoke-virtual {v5}, Ljava/io/BufferedWriter;->close()V

    .line 92
    invoke-virtual {v3}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v8

    sget-object v9, Lorg/pornaway/util/Constants;->ANDROID_SYSTEMLESS_SCRIPT:Ljava/lang/String;

    const/4 v10, 0x0

    const/4 v11, 0x0

    invoke-virtual {v4, v8, v9, v10, v11}, Lorg/sufficientlysecure/rootcommands/Toolbox;->copyFile(Ljava/lang/String;Ljava/lang/String;ZZ)Z

    move-result v8

    if-nez v8, :cond_95

    .line 93
    const-string v6, "PornAway"

    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    const-string v9, "Could not copy the systemless script to "

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    sget-object v9, Lorg/pornaway/util/Constants;->ANDROID_SYSTEMLESS_SCRIPT:Ljava/lang/String;

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    const-string v9, "."

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-static {v6, v8}, Lorg/pornaway/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    move v6, v7

    .line 94
    goto :goto_1e

    .line 97
    :cond_95
    sget-object v8, Lorg/pornaway/util/Constants;->ANDROID_SYSTEMLESS_SCRIPT:Ljava/lang/String;

    const-string v9, "755"

    invoke-virtual {v4, v8, v9}, Lorg/sufficientlysecure/rootcommands/Toolbox;->setFilePermissions(Ljava/lang/String;Ljava/lang/String;)Z

    move-result v8

    if-nez v8, :cond_a9

    .line 98
    const-string v6, "PornAway"

    const-string v8, "Could not set systemless script rights."

    invoke-static {v6, v8}, Lorg/pornaway/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    move v6, v7

    .line 99
    goto/16 :goto_1e

    .line 102
    :cond_a9
    invoke-virtual {v3}, Ljava/io/File;->delete()Z

    move-result v8

    if-nez v8, :cond_b6

    .line 103
    const-string v8, "PornAway"

    const-string v9, "Could not delete the temporary script file."

    invoke-static {v8, v9}, Lorg/pornaway/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 106
    :cond_b6
    new-instance v1, Lorg/sufficientlysecure/rootcommands/command/SimpleCommand;

    const/4 v8, 0x1

    new-array v8, v8, [Ljava/lang/String;

    const/4 v9, 0x0

    sget-object v10, Lorg/pornaway/util/Constants;->ANDROID_SYSTEMLESS_SCRIPT:Ljava/lang/String;

    aput-object v10, v8, v9

    invoke-direct {v1, v8}, Lorg/sufficientlysecure/rootcommands/command/SimpleCommand;-><init>([Ljava/lang/String;)V

    .line 107
    .local v1, "command":Lorg/sufficientlysecure/rootcommands/command/SimpleCommand;
    invoke-virtual {p1, v1}, Lorg/sufficientlysecure/rootcommands/Shell;->add(Lorg/sufficientlysecure/rootcommands/command/Command;)Lorg/sufficientlysecure/rootcommands/command/Command;

    move-result-object v8

    invoke-virtual {v8}, Lorg/sufficientlysecure/rootcommands/command/Command;->waitForFinish()V

    .line 108
    invoke-virtual {v1}, Lorg/sufficientlysecure/rootcommands/command/SimpleCommand;->getExitCode()I

    move-result v8

    if-eqz v8, :cond_da

    .line 109
    const-string v6, "PornAway"

    const-string v8, "Could not execute the systemless script."

    invoke-static {v6, v8}, Lorg/pornaway/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    move v6, v7

    .line 110
    goto/16 :goto_1e

    .line 113
    :cond_da
    invoke-static {p1}, Lorg/pornaway/util/SystemlessUtils;->isSystemlessModeEnabled(Lorg/sufficientlysecure/rootcommands/Shell;)Z

    move-result v8

    if-nez v8, :cond_1e

    .line 114
    const-string v6, "PornAway"

    const-string v8, "Systemless mode installation was successful but systemless is not working."

    invoke-static {v6, v8}, Lorg/pornaway/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_e7
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_e7} :catch_ea

    move v6, v7

    .line 115
    goto/16 :goto_1e

    .line 119
    .end local v0    # "cacheDir":Ljava/io/File;
    .end local v1    # "command":Lorg/sufficientlysecure/rootcommands/command/SimpleCommand;
    .end local v3    # "tempFile":Ljava/io/File;
    .end local v4    # "toolbox":Lorg/sufficientlysecure/rootcommands/Toolbox;
    .end local v5    # "writer":Ljava/io/BufferedWriter;
    :catch_ea
    move-exception v2

    .line 120
    .local v2, "exception":Ljava/lang/Exception;
    const-string v6, "PornAway"

    const-string v8, "Error while enabling systemless mode."

    invoke-static {v6, v8, v2}, Lorg/pornaway/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    move v6, v7

    .line 121
    goto/16 :goto_1e
.end method

.method public static isSystemlessModeEnabled(Lorg/sufficientlysecure/rootcommands/Shell;)Z
    .registers 9
    .param p0, "shell"    # Lorg/sufficientlysecure/rootcommands/Shell;

    .prologue
    const/4 v2, 0x1

    const/4 v3, 0x0

    .line 47
    :try_start_2
    new-instance v0, Lorg/sufficientlysecure/rootcommands/command/SimpleCommand;

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/String;

    const/4 v5, 0x0

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "mount | grep "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    sget-object v7, Lorg/pornaway/util/Constants;->ANDROID_SYSTEM_ETC_HOSTS:Ljava/lang/String;

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    invoke-direct {v0, v4}, Lorg/sufficientlysecure/rootcommands/command/SimpleCommand;-><init>([Ljava/lang/String;)V

    .line 48
    .local v0, "command":Lorg/sufficientlysecure/rootcommands/command/SimpleCommand;
    invoke-virtual {p0, v0}, Lorg/sufficientlysecure/rootcommands/Shell;->add(Lorg/sufficientlysecure/rootcommands/command/Command;)Lorg/sufficientlysecure/rootcommands/command/Command;

    move-result-object v4

    invoke-virtual {v4}, Lorg/sufficientlysecure/rootcommands/command/Command;->waitForFinish()V

    .line 49
    invoke-virtual {v0}, Lorg/sufficientlysecure/rootcommands/command/SimpleCommand;->getExitCode()I
    :try_end_2c
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2c} :catch_32

    move-result v4

    if-nez v4, :cond_30

    .line 53
    .end local v0    # "command":Lorg/sufficientlysecure/rootcommands/command/SimpleCommand;
    :goto_2f
    return v2

    .restart local v0    # "command":Lorg/sufficientlysecure/rootcommands/command/SimpleCommand;
    :cond_30
    move v2, v3

    .line 49
    goto :goto_2f

    .line 50
    .end local v0    # "command":Lorg/sufficientlysecure/rootcommands/command/SimpleCommand;
    :catch_32
    move-exception v1

    .line 51
    .local v1, "exception":Ljava/lang/Exception;
    const-string v2, "PornAway"

    const-string v4, "Error while checking if systemless mode is installed."

    invoke-static {v2, v4, v1}, Lorg/pornaway/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    move v2, v3

    .line 53
    goto :goto_2f
.end method

.method public static isSystemlessModeSupported(Lorg/sufficientlysecure/rootcommands/Shell;)Z
    .registers 5
    .param p0, "shell"    # Lorg/sufficientlysecure/rootcommands/Shell;

    .prologue
    .line 29
    :try_start_0
    new-instance v1, Lorg/sufficientlysecure/rootcommands/Toolbox;

    invoke-direct {v1, p0}, Lorg/sufficientlysecure/rootcommands/Toolbox;-><init>(Lorg/sufficientlysecure/rootcommands/Shell;)V

    .line 30
    .local v1, "toolbox":Lorg/sufficientlysecure/rootcommands/Toolbox;
    const-string v2, "/su/bin/su"

    invoke-virtual {v1, v2}, Lorg/sufficientlysecure/rootcommands/Toolbox;->fileExists(Ljava/lang/String;)Z
    :try_end_a
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_a} :catch_c

    move-result v2

    .line 33
    .end local v1    # "toolbox":Lorg/sufficientlysecure/rootcommands/Toolbox;
    :goto_b
    return v2

    .line 31
    :catch_c
    move-exception v0

    .line 32
    .local v0, "exception":Ljava/lang/Exception;
    const-string v2, "PornAway"

    const-string v3, "Error while checking if systemless mode is supported."

    invoke-static {v2, v3, v0}, Lorg/pornaway/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 33
    const/4 v2, 0x0

    goto :goto_b
.end method
