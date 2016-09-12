.class public Lorg/adaway/util/ApplyUtils;
.super Ljava/lang/Object;
.source "ApplyUtils.java"


# direct methods
.method public constructor <init>()V
    .registers 1

    .prologue
    .line 41
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static copyHostsFile(Landroid/content/Context;Ljava/lang/String;Lorg/sufficientlysecure/rootcommands/Shell;)V
    .registers 14
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "target"    # Ljava/lang/String;
    .param p2, "shell"    # Lorg/sufficientlysecure/rootcommands/Shell;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/adaway/util/NotEnoughSpaceException;,
            Lorg/adaway/util/RemountException;,
            Lorg/adaway/util/CommandException;
        }
    .end annotation

    .prologue
    .line 132
    const-string v7, "AdAway"

    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    const-string v9, "Copy hosts file with target: "

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-static {v7, v8}, Lorg/adaway/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 133
    invoke-virtual {p0}, Landroid/content/Context;->getFilesDir()Ljava/io/File;

    move-result-object v7

    invoke-virtual {v7}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v2

    .line 134
    .local v2, "privateDir":Ljava/lang/String;
    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v7, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    sget-object v8, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v8, "hosts"

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    .line 137
    .local v3, "privateFile":Ljava/lang/String;
    const-string v7, "/"

    invoke-virtual {p1, v7}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    move-result v7

    if-eqz v7, :cond_4e

    .line 138
    const-string v7, "AdAway"

    const-string v8, "Custom target ends with trailing slash, it is not a valid target!"

    invoke-static {v7, v8}, Lorg/adaway/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 140
    new-instance v7, Lorg/adaway/util/CommandException;

    invoke-direct {v7}, Lorg/adaway/util/CommandException;-><init>()V

    throw v7

    .line 143
    :cond_4e
    sget-object v7, Lorg/adaway/util/Constants;->ANDROID_SYSTEM_ETC_HOSTS:Ljava/lang/String;

    invoke-virtual {p1, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-nez v7, :cond_59

    .line 148
    invoke-static {p1, p2}, Lorg/adaway/util/ApplyUtils;->createDirectories(Ljava/lang/String;Lorg/sufficientlysecure/rootcommands/Shell;)V

    .line 152
    :cond_59
    new-instance v7, Ljava/io/File;

    invoke-direct {v7, v3}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    invoke-virtual {v7}, Ljava/io/File;->length()J

    move-result-wide v4

    .line 153
    .local v4, "size":J
    const-string v7, "AdAway"

    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    const-string v9, "Size of hosts file: "

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8, v4, v5}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-static {v7, v8}, Lorg/adaway/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 154
    invoke-static {p1, v4, v5}, Lorg/adaway/util/ApplyUtils;->hasEnoughSpaceOnPartition(Ljava/lang/String;J)Z

    move-result v7

    if-nez v7, :cond_86

    .line 155
    new-instance v7, Lorg/adaway/util/NotEnoughSpaceException;

    invoke-direct {v7}, Lorg/adaway/util/NotEnoughSpaceException;-><init>()V

    throw v7

    .line 158
    :cond_86
    new-instance v6, Lorg/sufficientlysecure/rootcommands/Toolbox;

    invoke-direct {v6, p2}, Lorg/sufficientlysecure/rootcommands/Toolbox;-><init>(Lorg/sufficientlysecure/rootcommands/Shell;)V

    .line 163
    .local v6, "tb":Lorg/sufficientlysecure/rootcommands/Toolbox;
    :try_start_8b
    const-string v7, "AdAway"

    const-string v8, "Remounting for RW..."

    invoke-static {v7, v8}, Lorg/adaway/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 164
    const-string v7, "RW"

    invoke-virtual {v6, p1, v7}, Lorg/sufficientlysecure/rootcommands/Toolbox;->remount(Ljava/lang/String;Ljava/lang/String;)Z

    move-result v7

    if-nez v7, :cond_a1

    .line 165
    const-string v7, "AdAway"

    const-string v8, "Remounting as RW failed! Probably not a problem!"

    invoke-static {v7, v8}, Lorg/adaway/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 169
    :cond_a1
    sget-object v7, Lorg/adaway/util/Constants;->ANDROID_SYSTEM_ETC_HOSTS:Ljava/lang/String;

    invoke-virtual {p1, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_ce

    .line 170
    new-instance v0, Lorg/sufficientlysecure/rootcommands/command/SimpleCommand;

    const/4 v7, 0x1

    new-array v7, v7, [Ljava/lang/String;

    const/4 v8, 0x0

    new-instance v9, Ljava/lang/StringBuilder;

    invoke-direct {v9}, Ljava/lang/StringBuilder;-><init>()V

    const-string v10, "rm -f "

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    aput-object v9, v7, v8

    invoke-direct {v0, v7}, Lorg/sufficientlysecure/rootcommands/command/SimpleCommand;-><init>([Ljava/lang/String;)V

    .line 171
    .local v0, "command":Lorg/sufficientlysecure/rootcommands/command/SimpleCommand;
    invoke-virtual {p2, v0}, Lorg/sufficientlysecure/rootcommands/Shell;->add(Lorg/sufficientlysecure/rootcommands/command/Command;)Lorg/sufficientlysecure/rootcommands/command/Command;

    move-result-object v7

    invoke-virtual {v7}, Lorg/sufficientlysecure/rootcommands/command/Command;->waitForFinish()V

    .line 175
    .end local v0    # "command":Lorg/sufficientlysecure/rootcommands/command/SimpleCommand;
    :cond_ce
    const/4 v7, 0x0

    const/4 v8, 0x0

    invoke-virtual {v6, v3, p1, v7, v8}, Lorg/sufficientlysecure/rootcommands/Toolbox;->copyFile(Ljava/lang/String;Ljava/lang/String;ZZ)Z

    move-result v7

    if-nez v7, :cond_10a

    .line 176
    new-instance v7, Lorg/adaway/util/CommandException;

    invoke-direct {v7}, Lorg/adaway/util/CommandException;-><init>()V

    throw v7
    :try_end_dc
    .catch Ljava/lang/Exception; {:try_start_8b .. :try_end_dc} :catch_dc
    .catchall {:try_start_8b .. :try_end_dc} :catchall_ea

    .line 183
    :catch_dc
    move-exception v1

    .line 184
    .local v1, "e":Ljava/lang/Exception;
    :try_start_dd
    const-string v7, "AdAway"

    const-string v8, "Exception!"

    invoke-static {v7, v8, v1}, Lorg/adaway/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 186
    new-instance v7, Lorg/adaway/util/CommandException;

    invoke-direct {v7}, Lorg/adaway/util/CommandException;-><init>()V

    throw v7
    :try_end_ea
    .catchall {:try_start_dd .. :try_end_ea} :catchall_ea

    .line 188
    .end local v1    # "e":Ljava/lang/Exception;
    :catchall_ea
    move-exception v7

    sget-object v8, Lorg/adaway/util/Constants;->ANDROID_SYSTEM_ETC_HOSTS:Ljava/lang/String;

    invoke-virtual {p1, v8}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v8

    if-eqz v8, :cond_109

    .line 190
    const-string v8, "AdAway"

    const-string v9, "Remounting back to RO..."

    invoke-static {v8, v9}, Lorg/adaway/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 191
    const-string v8, "RO"

    invoke-virtual {v6, p1, v8}, Lorg/sufficientlysecure/rootcommands/Toolbox;->remount(Ljava/lang/String;Ljava/lang/String;)Z

    move-result v8

    if-nez v8, :cond_109

    .line 192
    const-string v8, "AdAway"

    const-string v9, "Remounting failed in finally! Probably not a problem!"

    invoke-static {v8, v9}, Lorg/adaway/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)V

    :cond_109
    throw v7

    .line 180
    :cond_10a
    :try_start_10a
    new-instance v0, Lorg/sufficientlysecure/rootcommands/command/SimpleCommand;

    const/4 v7, 0x2

    new-array v7, v7, [Ljava/lang/String;

    const/4 v8, 0x0

    new-instance v9, Ljava/lang/StringBuilder;

    invoke-direct {v9}, Ljava/lang/StringBuilder;-><init>()V

    const-string v10, "chown 0:0 "

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    aput-object v9, v7, v8

    const/4 v8, 0x1

    new-instance v9, Ljava/lang/StringBuilder;

    invoke-direct {v9}, Ljava/lang/StringBuilder;-><init>()V

    const-string v10, "chmod 644 "

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    aput-object v9, v7, v8

    invoke-direct {v0, v7}, Lorg/sufficientlysecure/rootcommands/command/SimpleCommand;-><init>([Ljava/lang/String;)V

    .line 182
    .restart local v0    # "command":Lorg/sufficientlysecure/rootcommands/command/SimpleCommand;
    invoke-virtual {p2, v0}, Lorg/sufficientlysecure/rootcommands/Shell;->add(Lorg/sufficientlysecure/rootcommands/command/Command;)Lorg/sufficientlysecure/rootcommands/command/Command;

    move-result-object v7

    invoke-virtual {v7}, Lorg/sufficientlysecure/rootcommands/command/Command;->waitForFinish()V
    :try_end_145
    .catch Ljava/lang/Exception; {:try_start_10a .. :try_end_145} :catch_dc
    .catchall {:try_start_10a .. :try_end_145} :catchall_ea

    .line 188
    sget-object v7, Lorg/adaway/util/Constants;->ANDROID_SYSTEM_ETC_HOSTS:Ljava/lang/String;

    invoke-virtual {p1, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_163

    .line 190
    const-string v7, "AdAway"

    const-string v8, "Remounting back to RO..."

    invoke-static {v7, v8}, Lorg/adaway/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 191
    const-string v7, "RO"

    invoke-virtual {v6, p1, v7}, Lorg/sufficientlysecure/rootcommands/Toolbox;->remount(Ljava/lang/String;Ljava/lang/String;)Z

    move-result v7

    if-nez v7, :cond_163

    .line 192
    const-string v7, "AdAway"

    const-string v8, "Remounting failed in finally! Probably not a problem!"

    invoke-static {v7, v8}, Lorg/adaway/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 196
    :cond_163
    return-void
.end method

.method public static createDirectories(Ljava/lang/String;Lorg/sufficientlysecure/rootcommands/Shell;)V
    .registers 9
    .param p0, "target"    # Ljava/lang/String;
    .param p1, "shell"    # Lorg/sufficientlysecure/rootcommands/Shell;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/adaway/util/CommandException;
        }
    .end annotation

    .prologue
    .line 282
    :try_start_0
    new-instance v3, Ljava/io/File;

    invoke-direct {v3, p0}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3}, Ljava/io/File;->getParent()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/String;->toString()Ljava/lang/String;
    :try_end_c
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_c} :catch_3c

    move-result-object v0

    .line 286
    .local v0, "directory":Ljava/lang/String;
    :try_start_d
    new-instance v2, Lorg/sufficientlysecure/rootcommands/command/SimpleCommand;

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/String;

    const/4 v4, 0x0

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "mkdir -p "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-direct {v2, v3}, Lorg/sufficientlysecure/rootcommands/command/SimpleCommand;-><init>([Ljava/lang/String;)V

    .line 289
    .local v2, "mkdirCommand":Lorg/sufficientlysecure/rootcommands/command/SimpleCommand;
    invoke-virtual {p1, v2}, Lorg/sufficientlysecure/rootcommands/Shell;->add(Lorg/sufficientlysecure/rootcommands/command/Command;)Lorg/sufficientlysecure/rootcommands/command/Command;

    move-result-object v3

    invoke-virtual {v3}, Lorg/sufficientlysecure/rootcommands/command/Command;->waitForFinish()V
    :try_end_32
    .catch Ljava/lang/Exception; {:try_start_d .. :try_end_32} :catch_33

    .line 298
    .end local v2    # "mkdirCommand":Lorg/sufficientlysecure/rootcommands/command/SimpleCommand;
    :goto_32
    return-void

    .line 290
    :catch_33
    move-exception v1

    .line 291
    .local v1, "e":Ljava/lang/Exception;
    :try_start_34
    const-string v3, "AdAway"

    const-string v4, "Mkdir Exception"

    invoke-static {v3, v4, v1}, Lorg/adaway/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    :try_end_3b
    .catch Ljava/lang/Exception; {:try_start_34 .. :try_end_3b} :catch_3c

    goto :goto_32

    .line 293
    .end local v0    # "directory":Ljava/lang/String;
    .end local v1    # "e":Ljava/lang/Exception;
    :catch_3c
    move-exception v1

    .line 294
    .restart local v1    # "e":Ljava/lang/Exception;
    const-string v3, "AdAway"

    const-string v4, "Exception!"

    invoke-static {v3, v4, v1}, Lorg/adaway/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 296
    new-instance v3, Lorg/adaway/util/CommandException;

    invoke-direct {v3}, Lorg/adaway/util/CommandException;-><init>()V

    throw v3
.end method

.method public static createSymlink(Ljava/lang/String;)V
    .registers 9
    .param p0, "target"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/adaway/util/RemountException;,
            Lorg/adaway/util/CommandException;
        }
    .end annotation

    .prologue
    .line 204
    const/4 v2, 0x0

    .line 206
    .local v2, "rootShell":Lorg/sufficientlysecure/rootcommands/Shell;
    :try_start_1
    invoke-static {}, Lorg/sufficientlysecure/rootcommands/Shell;->startRootShell()Lorg/sufficientlysecure/rootcommands/Shell;
    :try_end_4
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_4} :catch_1a

    move-result-object v2

    .line 210
    new-instance v3, Lorg/sufficientlysecure/rootcommands/Toolbox;

    invoke-direct {v3, v2}, Lorg/sufficientlysecure/rootcommands/Toolbox;-><init>(Lorg/sufficientlysecure/rootcommands/Shell;)V

    .line 213
    .local v3, "tb":Lorg/sufficientlysecure/rootcommands/Toolbox;
    sget-object v4, Lorg/adaway/util/Constants;->ANDROID_SYSTEM_ETC_HOSTS:Ljava/lang/String;

    const-string v5, "RW"

    invoke-virtual {v3, v4, v5}, Lorg/sufficientlysecure/rootcommands/Toolbox;->remount(Ljava/lang/String;Ljava/lang/String;)Z

    move-result v4

    if-nez v4, :cond_23

    .line 214
    new-instance v4, Lorg/adaway/util/RemountException;

    invoke-direct {v4}, Lorg/adaway/util/RemountException;-><init>()V

    throw v4

    .line 207
    .end local v3    # "tb":Lorg/sufficientlysecure/rootcommands/Toolbox;
    :catch_1a
    move-exception v1

    .line 208
    .local v1, "e":Ljava/lang/Exception;
    new-instance v4, Lorg/adaway/util/CommandException;

    const-string v5, "Problem opening root shell!"

    invoke-direct {v4, v5}, Lorg/adaway/util/CommandException;-><init>(Ljava/lang/String;)V

    throw v4

    .line 220
    .end local v1    # "e":Ljava/lang/Exception;
    .restart local v3    # "tb":Lorg/sufficientlysecure/rootcommands/Toolbox;
    :cond_23
    :try_start_23
    new-instance v0, Lorg/sufficientlysecure/rootcommands/command/SimpleCommand;

    const/4 v4, 0x5

    new-array v4, v4, [Ljava/lang/String;

    const/4 v5, 0x0

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "rm -f "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    sget-object v7, Lorg/adaway/util/Constants;->ANDROID_SYSTEM_ETC_HOSTS:Ljava/lang/String;

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    const/4 v5, 0x1

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "ln -s "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, " "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    sget-object v7, Lorg/adaway/util/Constants;->ANDROID_SYSTEM_ETC_HOSTS:Ljava/lang/String;

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    const/4 v5, 0x2

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "chcon u:object_r:system_file:s0 "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    const/4 v5, 0x3

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "chown 0:0 "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    const/4 v5, 0x4

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "chmod 644 "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    invoke-direct {v0, v4}, Lorg/sufficientlysecure/rootcommands/command/SimpleCommand;-><init>([Ljava/lang/String;)V

    .line 228
    .local v0, "command":Lorg/sufficientlysecure/rootcommands/command/SimpleCommand;
    invoke-virtual {v2, v0}, Lorg/sufficientlysecure/rootcommands/Shell;->add(Lorg/sufficientlysecure/rootcommands/command/Command;)Lorg/sufficientlysecure/rootcommands/command/Command;

    move-result-object v4

    invoke-virtual {v4}, Lorg/sufficientlysecure/rootcommands/command/Command;->waitForFinish()V
    :try_end_ae
    .catch Ljava/lang/Exception; {:try_start_23 .. :try_end_ae} :catch_c2
    .catchall {:try_start_23 .. :try_end_ae} :catchall_c9

    .line 233
    sget-object v4, Lorg/adaway/util/Constants;->ANDROID_SYSTEM_ETC_HOSTS:Ljava/lang/String;

    const-string v5, "RO"

    invoke-virtual {v3, v4, v5}, Lorg/sufficientlysecure/rootcommands/Toolbox;->remount(Ljava/lang/String;Ljava/lang/String;)Z

    .line 236
    :try_start_b5
    invoke-virtual {v2}, Lorg/sufficientlysecure/rootcommands/Shell;->close()V
    :try_end_b8
    .catch Ljava/io/IOException; {:try_start_b5 .. :try_end_b8} :catch_b9

    .line 241
    return-void

    .line 237
    :catch_b9
    move-exception v1

    .line 238
    .local v1, "e":Ljava/io/IOException;
    new-instance v4, Lorg/adaway/util/CommandException;

    const-string v5, "Problem closing root shell!"

    invoke-direct {v4, v5}, Lorg/adaway/util/CommandException;-><init>(Ljava/lang/String;)V

    throw v4

    .line 229
    .end local v0    # "command":Lorg/sufficientlysecure/rootcommands/command/SimpleCommand;
    .end local v1    # "e":Ljava/io/IOException;
    :catch_c2
    move-exception v1

    .line 230
    .local v1, "e":Ljava/lang/Exception;
    :try_start_c3
    new-instance v4, Lorg/adaway/util/CommandException;

    invoke-direct {v4}, Lorg/adaway/util/CommandException;-><init>()V

    throw v4
    :try_end_c9
    .catchall {:try_start_c3 .. :try_end_c9} :catchall_c9

    .line 233
    .end local v1    # "e":Ljava/lang/Exception;
    :catchall_c9
    move-exception v4

    sget-object v5, Lorg/adaway/util/Constants;->ANDROID_SYSTEM_ETC_HOSTS:Ljava/lang/String;

    const-string v6, "RO"

    invoke-virtual {v3, v5, v6}, Lorg/sufficientlysecure/rootcommands/Toolbox;->remount(Ljava/lang/String;Ljava/lang/String;)Z

    .line 236
    :try_start_d1
    invoke-virtual {v2}, Lorg/sufficientlysecure/rootcommands/Shell;->close()V
    :try_end_d4
    .catch Ljava/io/IOException; {:try_start_d1 .. :try_end_d4} :catch_d5

    .line 238
    throw v4

    .line 237
    :catch_d5
    move-exception v1

    .line 238
    .local v1, "e":Ljava/io/IOException;
    new-instance v4, Lorg/adaway/util/CommandException;

    const-string v5, "Problem closing root shell!"

    invoke-direct {v4, v5}, Lorg/adaway/util/CommandException;-><init>(Ljava/lang/String;)V

    throw v4
.end method

.method public static hasEnoughSpaceOnPartition(Ljava/lang/String;J)Z
    .registers 16
    .param p0, "target"    # Ljava/lang/String;
    .param p1, "size"    # J

    .prologue
    const/4 v9, 0x1

    .line 54
    :try_start_1
    new-instance v10, Ljava/io/File;

    invoke-direct {v10, p0}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    invoke-virtual {v10}, Ljava/io/File;->getParent()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/String;->toString()Ljava/lang/String;

    move-result-object v6

    .line 56
    .local v6, "directory":Ljava/lang/String;
    new-instance v8, Landroid/os/StatFs;

    invoke-direct {v8, v6}, Landroid/os/StatFs;-><init>(Ljava/lang/String;)V

    .line 57
    .local v8, "stat":Landroid/os/StatFs;
    invoke-virtual {v8}, Landroid/os/StatFs;->getBlockSize()I

    move-result v10

    int-to-long v4, v10

    .line 58
    .local v4, "blockSize":J
    invoke-virtual {v8}, Landroid/os/StatFs;->getAvailableBlocks()I

    move-result v10

    int-to-long v0, v10

    .line 59
    .local v0, "availableBlocks":J
    mul-long v2, v0, v4

    .line 61
    .local v2, "availableSpace":J
    const-string v10, "AdAway"

    new-instance v11, Ljava/lang/StringBuilder;

    invoke-direct {v11}, Ljava/lang/StringBuilder;-><init>()V

    const-string v12, "Checking for enough space: Target: "

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v11, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    const-string v12, ", directory: "

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v11, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    const-string v12, " size: "

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v11, p1, p2}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v11

    const-string v12, ", availableSpace: "

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v11, v2, v3}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v11}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v11

    invoke-static {v10, v11}, Lorg/adaway/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 64
    cmp-long v10, p1, v2

    if-gez v10, :cond_5a

    .line 74
    .end local v0    # "availableBlocks":J
    .end local v2    # "availableSpace":J
    .end local v4    # "blockSize":J
    .end local v6    # "directory":Ljava/lang/String;
    .end local v8    # "stat":Landroid/os/StatFs;
    :goto_59
    return v9

    .line 67
    .restart local v0    # "availableBlocks":J
    .restart local v2    # "availableSpace":J
    .restart local v4    # "blockSize":J
    .restart local v6    # "directory":Ljava/lang/String;
    .restart local v8    # "stat":Landroid/os/StatFs;
    :cond_5a
    const-string v10, "AdAway"

    const-string v11, "Not enough space on partition!"

    invoke-static {v10, v11}, Lorg/adaway/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_61
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_61} :catch_63

    .line 68
    const/4 v9, 0x0

    goto :goto_59

    .line 70
    .end local v0    # "availableBlocks":J
    .end local v2    # "availableSpace":J
    .end local v4    # "blockSize":J
    .end local v6    # "directory":Ljava/lang/String;
    .end local v8    # "stat":Landroid/os/StatFs;
    :catch_63
    move-exception v7

    .line 73
    .local v7, "e":Ljava/lang/Exception;
    const-string v10, "AdAway"

    const-string v11, "Problem while getting available space on partition!"

    invoke-static {v10, v11, v7}, Lorg/adaway/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_59
.end method

.method public static isApnProxySet(Landroid/content/Context;)Z
    .registers 14
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 309
    const/4 v12, 0x0

    .line 312
    .local v12, "result":Z
    :try_start_1
    const-string v0, "content://telephony/carriers/preferapn"

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    .line 313
    .local v1, "defaultApnUri":Landroid/net/Uri;
    const/4 v0, 0x3

    new-array v2, v0, [Ljava/lang/String;

    const/4 v0, 0x0

    const-string v3, "_id"

    aput-object v3, v2, v0

    const/4 v0, 0x1

    const-string v3, "name"

    aput-object v3, v2, v0

    const/4 v0, 0x2

    const-string v3, "proxy"

    aput-object v3, v2, v0

    .line 315
    .local v2, "projection":[Ljava/lang/String;
    invoke-virtual {p0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    const/4 v3, 0x0

    const/4 v4, 0x0

    const/4 v5, 0x0

    invoke-virtual/range {v0 .. v5}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v6

    .line 319
    .local v6, "cursor":Landroid/database/Cursor;
    if-eqz v6, :cond_6f

    .line 321
    const-string v0, "name"

    invoke-interface {v6, v0}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v9

    .line 322
    .local v9, "nameColumn":I
    const-string v0, "proxy"

    invoke-interface {v6, v0}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v11

    .line 324
    .local v11, "proxyColumn":I
    invoke-interface {v6}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v0

    if-eqz v0, :cond_6b

    .line 326
    invoke-interface {v6, v9}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v8

    .line 327
    .local v8, "name":Ljava/lang/String;
    invoke-interface {v6, v11}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v10

    .line 329
    .local v10, "proxy":Ljava/lang/String;
    const-string v0, "AdAway"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "APN "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " has proxy: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v0, v3}, Lorg/adaway/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 332
    const-string v0, "\\s*"

    invoke-virtual {v10, v0}, Ljava/lang/String;->matches(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_6b

    .line 333
    const/4 v12, 0x1

    .line 337
    .end local v8    # "name":Ljava/lang/String;
    .end local v10    # "proxy":Ljava/lang/String;
    :cond_6b
    invoke-interface {v6}, Landroid/database/Cursor;->close()V

    .line 346
    .end local v1    # "defaultApnUri":Landroid/net/Uri;
    .end local v2    # "projection":[Ljava/lang/String;
    .end local v6    # "cursor":Landroid/database/Cursor;
    .end local v9    # "nameColumn":I
    .end local v11    # "proxyColumn":I
    :goto_6e
    return v12

    .line 339
    .restart local v1    # "defaultApnUri":Landroid/net/Uri;
    .restart local v2    # "projection":[Ljava/lang/String;
    .restart local v6    # "cursor":Landroid/database/Cursor;
    :cond_6f
    const-string v0, "AdAway"

    const-string v3, "Could not get APN cursor!"

    invoke-static {v0, v3}, Lorg/adaway/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_76
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_76} :catch_77

    goto :goto_6e

    .line 341
    .end local v1    # "defaultApnUri":Landroid/net/Uri;
    .end local v2    # "projection":[Ljava/lang/String;
    .end local v6    # "cursor":Landroid/database/Cursor;
    :catch_77
    move-exception v7

    .line 342
    .local v7, "e":Ljava/lang/Exception;
    const-string v0, "AdAway"

    const-string v3, "Error while getting default APN!"

    invoke-static {v0, v3, v7}, Lorg/adaway/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_6e
.end method

.method public static isHostsFileCorrect(Landroid/content/Context;Ljava/lang/String;)Z
    .registers 15
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "target"    # Ljava/lang/String;

    .prologue
    .line 84
    const/4 v7, 0x0

    .line 87
    .local v7, "status":Z
    const/4 v8, 0x0

    .line 88
    .local v8, "stream":Ljava/io/InputStream;
    const/4 v5, 0x0

    .line 89
    .local v5, "in":Ljava/io/InputStreamReader;
    const/4 v0, 0x0

    .line 91
    .local v0, "br":Ljava/io/BufferedReader;
    :try_start_4
    new-instance v3, Ljava/io/File;

    invoke-direct {v3, p1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 93
    .local v3, "file":Ljava/io/File;
    new-instance v9, Ljava/io/FileInputStream;

    invoke-direct {v9, v3}, Ljava/io/FileInputStream;-><init>(Ljava/io/File;)V
    :try_end_e
    .catch Ljava/io/FileNotFoundException; {:try_start_4 .. :try_end_e} :catch_5e
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_e} :catch_76
    .catchall {:try_start_4 .. :try_end_e} :catchall_8e

    .line 94
    .end local v8    # "stream":Ljava/io/InputStream;
    .local v9, "stream":Ljava/io/InputStream;
    :try_start_e
    new-instance v6, Ljava/io/InputStreamReader;

    invoke-direct {v6, v9}, Ljava/io/InputStreamReader;-><init>(Ljava/io/InputStream;)V
    :try_end_13
    .catch Ljava/io/FileNotFoundException; {:try_start_e .. :try_end_13} :catch_b6
    .catch Ljava/lang/Exception; {:try_start_e .. :try_end_13} :catch_aa
    .catchall {:try_start_e .. :try_end_13} :catchall_9e

    .line 95
    .end local v5    # "in":Ljava/io/InputStreamReader;
    .local v6, "in":Ljava/io/InputStreamReader;
    :try_start_13
    new-instance v1, Ljava/io/BufferedReader;

    invoke-direct {v1, v6}, Ljava/io/BufferedReader;-><init>(Ljava/io/Reader;)V
    :try_end_18
    .catch Ljava/io/FileNotFoundException; {:try_start_13 .. :try_end_18} :catch_b9
    .catch Ljava/lang/Exception; {:try_start_13 .. :try_end_18} :catch_ad
    .catchall {:try_start_13 .. :try_end_18} :catchall_a1

    .line 97
    .end local v0    # "br":Ljava/io/BufferedReader;
    .local v1, "br":Ljava/io/BufferedReader;
    :try_start_18
    invoke-virtual {v1}, Ljava/io/BufferedReader;->readLine()Ljava/lang/String;

    move-result-object v4

    .line 99
    .local v4, "firstLine":Ljava/lang/String;
    const-string v10, "AdAway"

    new-instance v11, Ljava/lang/StringBuilder;

    invoke-direct {v11}, Ljava/lang/StringBuilder;-><init>()V

    const-string v12, "First line of "

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v11, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    const-string v12, ": "

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v11, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v11}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v11

    invoke-static {v10, v11}, Lorg/adaway/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 101
    const-string v10, "# This hosts file has been generated by PornAway on:"

    invoke-virtual {v4, v10}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    :try_end_43
    .catch Ljava/io/FileNotFoundException; {:try_start_18 .. :try_end_43} :catch_bd
    .catch Ljava/lang/Exception; {:try_start_18 .. :try_end_43} :catch_b1
    .catchall {:try_start_18 .. :try_end_43} :catchall_a5

    move-result v10

    if-eqz v10, :cond_50

    .line 102
    const/4 v7, 0x1

    .line 113
    :goto_47
    if-eqz v9, :cond_c2

    .line 115
    :try_start_49
    invoke-virtual {v9}, Ljava/io/InputStream;->close()V
    :try_end_4c
    .catch Ljava/io/IOException; {:try_start_49 .. :try_end_4c} :catch_52

    move-object v0, v1

    .end local v1    # "br":Ljava/io/BufferedReader;
    .restart local v0    # "br":Ljava/io/BufferedReader;
    move-object v5, v6

    .end local v6    # "in":Ljava/io/InputStreamReader;
    .restart local v5    # "in":Ljava/io/InputStreamReader;
    move-object v8, v9

    .line 122
    .end local v3    # "file":Ljava/io/File;
    .end local v4    # "firstLine":Ljava/lang/String;
    .end local v9    # "stream":Ljava/io/InputStream;
    .restart local v8    # "stream":Ljava/io/InputStream;
    :cond_4f
    :goto_4f
    return v7

    .line 104
    .end local v0    # "br":Ljava/io/BufferedReader;
    .end local v5    # "in":Ljava/io/InputStreamReader;
    .end local v8    # "stream":Ljava/io/InputStream;
    .restart local v1    # "br":Ljava/io/BufferedReader;
    .restart local v3    # "file":Ljava/io/File;
    .restart local v4    # "firstLine":Ljava/lang/String;
    .restart local v6    # "in":Ljava/io/InputStreamReader;
    .restart local v9    # "stream":Ljava/io/InputStream;
    :cond_50
    const/4 v7, 0x0

    goto :goto_47

    .line 116
    :catch_52
    move-exception v2

    .line 117
    .local v2, "e":Ljava/io/IOException;
    const-string v10, "AdAway"

    const-string v11, "Exception"

    invoke-static {v10, v11, v2}, Lorg/adaway/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    move-object v0, v1

    .end local v1    # "br":Ljava/io/BufferedReader;
    .restart local v0    # "br":Ljava/io/BufferedReader;
    move-object v5, v6

    .end local v6    # "in":Ljava/io/InputStreamReader;
    .restart local v5    # "in":Ljava/io/InputStreamReader;
    move-object v8, v9

    .line 118
    .end local v9    # "stream":Ljava/io/InputStream;
    .restart local v8    # "stream":Ljava/io/InputStream;
    goto :goto_4f

    .line 106
    .end local v2    # "e":Ljava/io/IOException;
    .end local v3    # "file":Ljava/io/File;
    .end local v4    # "firstLine":Ljava/lang/String;
    :catch_5e
    move-exception v2

    .line 107
    .local v2, "e":Ljava/io/FileNotFoundException;
    :goto_5f
    :try_start_5f
    const-string v10, "AdAway"

    const-string v11, "FileNotFoundException"

    invoke-static {v10, v11, v2}, Lorg/adaway/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    :try_end_66
    .catchall {:try_start_5f .. :try_end_66} :catchall_8e

    .line 108
    const/4 v7, 0x1

    .line 113
    if-eqz v8, :cond_4f

    .line 115
    :try_start_69
    invoke-virtual {v8}, Ljava/io/InputStream;->close()V
    :try_end_6c
    .catch Ljava/io/IOException; {:try_start_69 .. :try_end_6c} :catch_6d

    goto :goto_4f

    .line 116
    :catch_6d
    move-exception v2

    .line 117
    .local v2, "e":Ljava/io/IOException;
    const-string v10, "AdAway"

    const-string v11, "Exception"

    invoke-static {v10, v11, v2}, Lorg/adaway/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_4f

    .line 109
    .end local v2    # "e":Ljava/io/IOException;
    :catch_76
    move-exception v2

    .line 110
    .local v2, "e":Ljava/lang/Exception;
    :goto_77
    :try_start_77
    const-string v10, "AdAway"

    const-string v11, "Exception: "

    invoke-static {v10, v11, v2}, Lorg/adaway/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    :try_end_7e
    .catchall {:try_start_77 .. :try_end_7e} :catchall_8e

    .line 111
    const/4 v7, 0x0

    .line 113
    if-eqz v8, :cond_4f

    .line 115
    :try_start_81
    invoke-virtual {v8}, Ljava/io/InputStream;->close()V
    :try_end_84
    .catch Ljava/io/IOException; {:try_start_81 .. :try_end_84} :catch_85

    goto :goto_4f

    .line 116
    :catch_85
    move-exception v2

    .line 117
    .local v2, "e":Ljava/io/IOException;
    const-string v10, "AdAway"

    const-string v11, "Exception"

    invoke-static {v10, v11, v2}, Lorg/adaway/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_4f

    .line 113
    .end local v2    # "e":Ljava/io/IOException;
    :catchall_8e
    move-exception v10

    :goto_8f
    if-eqz v8, :cond_94

    .line 115
    :try_start_91
    invoke-virtual {v8}, Ljava/io/InputStream;->close()V
    :try_end_94
    .catch Ljava/io/IOException; {:try_start_91 .. :try_end_94} :catch_95

    .line 118
    :cond_94
    :goto_94
    throw v10

    .line 116
    :catch_95
    move-exception v2

    .line 117
    .restart local v2    # "e":Ljava/io/IOException;
    const-string v11, "AdAway"

    const-string v12, "Exception"

    invoke-static {v11, v12, v2}, Lorg/adaway/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_94

    .line 113
    .end local v2    # "e":Ljava/io/IOException;
    .end local v8    # "stream":Ljava/io/InputStream;
    .restart local v3    # "file":Ljava/io/File;
    .restart local v9    # "stream":Ljava/io/InputStream;
    :catchall_9e
    move-exception v10

    move-object v8, v9

    .end local v9    # "stream":Ljava/io/InputStream;
    .restart local v8    # "stream":Ljava/io/InputStream;
    goto :goto_8f

    .end local v5    # "in":Ljava/io/InputStreamReader;
    .end local v8    # "stream":Ljava/io/InputStream;
    .restart local v6    # "in":Ljava/io/InputStreamReader;
    .restart local v9    # "stream":Ljava/io/InputStream;
    :catchall_a1
    move-exception v10

    move-object v5, v6

    .end local v6    # "in":Ljava/io/InputStreamReader;
    .restart local v5    # "in":Ljava/io/InputStreamReader;
    move-object v8, v9

    .end local v9    # "stream":Ljava/io/InputStream;
    .restart local v8    # "stream":Ljava/io/InputStream;
    goto :goto_8f

    .end local v0    # "br":Ljava/io/BufferedReader;
    .end local v5    # "in":Ljava/io/InputStreamReader;
    .end local v8    # "stream":Ljava/io/InputStream;
    .restart local v1    # "br":Ljava/io/BufferedReader;
    .restart local v6    # "in":Ljava/io/InputStreamReader;
    .restart local v9    # "stream":Ljava/io/InputStream;
    :catchall_a5
    move-exception v10

    move-object v0, v1

    .end local v1    # "br":Ljava/io/BufferedReader;
    .restart local v0    # "br":Ljava/io/BufferedReader;
    move-object v5, v6

    .end local v6    # "in":Ljava/io/InputStreamReader;
    .restart local v5    # "in":Ljava/io/InputStreamReader;
    move-object v8, v9

    .end local v9    # "stream":Ljava/io/InputStream;
    .restart local v8    # "stream":Ljava/io/InputStream;
    goto :goto_8f

    .line 109
    .end local v8    # "stream":Ljava/io/InputStream;
    .restart local v9    # "stream":Ljava/io/InputStream;
    :catch_aa
    move-exception v2

    move-object v8, v9

    .end local v9    # "stream":Ljava/io/InputStream;
    .restart local v8    # "stream":Ljava/io/InputStream;
    goto :goto_77

    .end local v5    # "in":Ljava/io/InputStreamReader;
    .end local v8    # "stream":Ljava/io/InputStream;
    .restart local v6    # "in":Ljava/io/InputStreamReader;
    .restart local v9    # "stream":Ljava/io/InputStream;
    :catch_ad
    move-exception v2

    move-object v5, v6

    .end local v6    # "in":Ljava/io/InputStreamReader;
    .restart local v5    # "in":Ljava/io/InputStreamReader;
    move-object v8, v9

    .end local v9    # "stream":Ljava/io/InputStream;
    .restart local v8    # "stream":Ljava/io/InputStream;
    goto :goto_77

    .end local v0    # "br":Ljava/io/BufferedReader;
    .end local v5    # "in":Ljava/io/InputStreamReader;
    .end local v8    # "stream":Ljava/io/InputStream;
    .restart local v1    # "br":Ljava/io/BufferedReader;
    .restart local v6    # "in":Ljava/io/InputStreamReader;
    .restart local v9    # "stream":Ljava/io/InputStream;
    :catch_b1
    move-exception v2

    move-object v0, v1

    .end local v1    # "br":Ljava/io/BufferedReader;
    .restart local v0    # "br":Ljava/io/BufferedReader;
    move-object v5, v6

    .end local v6    # "in":Ljava/io/InputStreamReader;
    .restart local v5    # "in":Ljava/io/InputStreamReader;
    move-object v8, v9

    .end local v9    # "stream":Ljava/io/InputStream;
    .restart local v8    # "stream":Ljava/io/InputStream;
    goto :goto_77

    .line 106
    .end local v8    # "stream":Ljava/io/InputStream;
    .restart local v9    # "stream":Ljava/io/InputStream;
    :catch_b6
    move-exception v2

    move-object v8, v9

    .end local v9    # "stream":Ljava/io/InputStream;
    .restart local v8    # "stream":Ljava/io/InputStream;
    goto :goto_5f

    .end local v5    # "in":Ljava/io/InputStreamReader;
    .end local v8    # "stream":Ljava/io/InputStream;
    .restart local v6    # "in":Ljava/io/InputStreamReader;
    .restart local v9    # "stream":Ljava/io/InputStream;
    :catch_b9
    move-exception v2

    move-object v5, v6

    .end local v6    # "in":Ljava/io/InputStreamReader;
    .restart local v5    # "in":Ljava/io/InputStreamReader;
    move-object v8, v9

    .end local v9    # "stream":Ljava/io/InputStream;
    .restart local v8    # "stream":Ljava/io/InputStream;
    goto :goto_5f

    .end local v0    # "br":Ljava/io/BufferedReader;
    .end local v5    # "in":Ljava/io/InputStreamReader;
    .end local v8    # "stream":Ljava/io/InputStream;
    .restart local v1    # "br":Ljava/io/BufferedReader;
    .restart local v6    # "in":Ljava/io/InputStreamReader;
    .restart local v9    # "stream":Ljava/io/InputStream;
    :catch_bd
    move-exception v2

    move-object v0, v1

    .end local v1    # "br":Ljava/io/BufferedReader;
    .restart local v0    # "br":Ljava/io/BufferedReader;
    move-object v5, v6

    .end local v6    # "in":Ljava/io/InputStreamReader;
    .restart local v5    # "in":Ljava/io/InputStreamReader;
    move-object v8, v9

    .end local v9    # "stream":Ljava/io/InputStream;
    .restart local v8    # "stream":Ljava/io/InputStream;
    goto :goto_5f

    .end local v0    # "br":Ljava/io/BufferedReader;
    .end local v5    # "in":Ljava/io/InputStreamReader;
    .end local v8    # "stream":Ljava/io/InputStream;
    .restart local v1    # "br":Ljava/io/BufferedReader;
    .restart local v4    # "firstLine":Ljava/lang/String;
    .restart local v6    # "in":Ljava/io/InputStreamReader;
    .restart local v9    # "stream":Ljava/io/InputStream;
    :cond_c2
    move-object v0, v1

    .end local v1    # "br":Ljava/io/BufferedReader;
    .restart local v0    # "br":Ljava/io/BufferedReader;
    move-object v5, v6

    .end local v6    # "in":Ljava/io/InputStreamReader;
    .restart local v5    # "in":Ljava/io/InputStreamReader;
    move-object v8, v9

    .end local v9    # "stream":Ljava/io/InputStream;
    .restart local v8    # "stream":Ljava/io/InputStream;
    goto :goto_4f
.end method

.method public static isSymlinkCorrect(Ljava/lang/String;Lorg/sufficientlysecure/rootcommands/Shell;)Z
    .registers 9
    .param p0, "target"    # Ljava/lang/String;
    .param p1, "shell"    # Lorg/sufficientlysecure/rootcommands/Shell;

    .prologue
    const/4 v3, 0x0

    .line 251
    const-string v4, "AdAway"

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "Checking whether /system/etc/hosts is a symlink and pointing to "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, " or not."

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Lorg/adaway/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 254
    new-instance v2, Lorg/sufficientlysecure/rootcommands/Toolbox;

    invoke-direct {v2, p1}, Lorg/sufficientlysecure/rootcommands/Toolbox;-><init>(Lorg/sufficientlysecure/rootcommands/Shell;)V

    .line 255
    .local v2, "tb":Lorg/sufficientlysecure/rootcommands/Toolbox;
    const/4 v1, 0x0

    .line 257
    .local v1, "symlink":Ljava/lang/String;
    :try_start_25
    sget-object v4, Lorg/adaway/util/Constants;->ANDROID_SYSTEM_ETC_HOSTS:Ljava/lang/String;

    invoke-virtual {v2, v4}, Lorg/sufficientlysecure/rootcommands/Toolbox;->getSymlink(Ljava/lang/String;)Ljava/lang/String;
    :try_end_2a
    .catch Ljava/lang/Exception; {:try_start_25 .. :try_end_2a} :catch_57

    move-result-object v1

    .line 263
    const-string v4, "AdAway"

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "symlink: "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, "; target: "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Lorg/adaway/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 265
    if-eqz v1, :cond_56

    invoke-virtual {v1, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_56

    .line 266
    const/4 v3, 0x1

    .line 268
    :cond_56
    :goto_56
    return v3

    .line 258
    :catch_57
    move-exception v0

    .line 259
    .local v0, "e":Ljava/lang/Exception;
    const-string v4, "AdAway"

    const-string v5, "Problem getting symlink!"

    invoke-static {v4, v5, v0}, Lorg/adaway/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_56
.end method
