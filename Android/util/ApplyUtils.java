.class public Lorg/pornaway/util/ApplyUtils;
.super Ljava/lang/Object;
.source "ApplyUtils.java"


# direct methods
.method public constructor <init>()V
    .registers 1

    .prologue
    .line 40
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static copyHostsFile(Landroid/content/Context;Ljava/lang/String;Lorg/sufficientlysecure/rootcommands/Shell;)V
    .registers 15
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "target"    # Ljava/lang/String;
    .param p2, "shell"    # Lorg/sufficientlysecure/rootcommands/Shell;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/pornaway/util/NotEnoughSpaceException;,
            Lorg/pornaway/util/RemountException;,
            Lorg/pornaway/util/CommandException;
        }
    .end annotation

    .prologue
    .line 141
    const-string v8, "PornAway"

    new-instance v9, Ljava/lang/StringBuilder;

    invoke-direct {v9}, Ljava/lang/StringBuilder;-><init>()V

    const-string v10, "Copy hosts file with target: "

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-static {v8, v9}, Lorg/pornaway/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 142
    invoke-virtual {p0}, Landroid/content/Context;->getFilesDir()Ljava/io/File;

    move-result-object v8

    invoke-virtual {v8}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v2

    .line 143
    .local v2, "privateDir":Ljava/lang/String;
    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v8, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    sget-object v9, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    const-string v9, "hosts"

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    .line 146
    .local v3, "privateFile":Ljava/lang/String;
    const-string v8, "/"

    invoke-virtual {p1, v8}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    move-result v8

    if-eqz v8, :cond_4e

    .line 147
    const-string v8, "PornAway"

    const-string v9, "Custom target ends with trailing slash, it is not a valid target!"

    invoke-static {v8, v9}, Lorg/pornaway/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 149
    new-instance v8, Lorg/pornaway/util/CommandException;

    invoke-direct {v8}, Lorg/pornaway/util/CommandException;-><init>()V

    throw v8

    .line 152
    :cond_4e
    sget-object v8, Lorg/pornaway/util/Constants;->ANDROID_SYSTEM_ETC_HOSTS:Ljava/lang/String;

    invoke-virtual {p1, v8}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v8

    if-nez v8, :cond_59

    .line 157
    invoke-static {p1, p2}, Lorg/pornaway/util/ApplyUtils;->createDirectories(Ljava/lang/String;Lorg/sufficientlysecure/rootcommands/Shell;)V

    .line 161
    :cond_59
    new-instance v8, Ljava/io/File;

    invoke-direct {v8, v3}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    invoke-virtual {v8}, Ljava/io/File;->length()J

    move-result-wide v4

    .line 162
    .local v4, "size":J
    const-string v8, "PornAway"

    new-instance v9, Ljava/lang/StringBuilder;

    invoke-direct {v9}, Ljava/lang/StringBuilder;-><init>()V

    const-string v10, "Size of hosts file: "

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9, v4, v5}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-static {v8, v9}, Lorg/pornaway/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 163
    invoke-static {p1, v4, v5}, Lorg/pornaway/util/ApplyUtils;->hasEnoughSpaceOnPartition(Ljava/lang/String;J)Z

    move-result v8

    if-nez v8, :cond_86

    .line 164
    new-instance v8, Lorg/pornaway/util/NotEnoughSpaceException;

    invoke-direct {v8}, Lorg/pornaway/util/NotEnoughSpaceException;-><init>()V

    throw v8

    .line 167
    :cond_86
    new-instance v6, Lorg/sufficientlysecure/rootcommands/Toolbox;

    invoke-direct {v6, p2}, Lorg/sufficientlysecure/rootcommands/Toolbox;-><init>(Lorg/sufficientlysecure/rootcommands/Shell;)V

    .line 168
    .local v6, "tb":Lorg/sufficientlysecure/rootcommands/Toolbox;
    invoke-static {p2, p1}, Lorg/pornaway/util/ApplyUtils;->isWritable(Lorg/sufficientlysecure/rootcommands/Shell;Ljava/lang/String;)Z

    move-result v7

    .line 171
    .local v7, "writable":Z
    if-nez v7, :cond_a7

    .line 173
    :try_start_91
    const-string v8, "PornAway"

    const-string v9, "Remounting for RW..."

    invoke-static {v8, v9}, Lorg/pornaway/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 174
    const-string v8, "RW"

    invoke-virtual {v6, p1, v8}, Lorg/sufficientlysecure/rootcommands/Toolbox;->remount(Ljava/lang/String;Ljava/lang/String;)Z

    move-result v8

    if-nez v8, :cond_a7

    .line 175
    const-string v8, "PornAway"

    const-string v9, "Remounting as RW failed! Probably not a problem!"

    invoke-static {v8, v9}, Lorg/pornaway/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 179
    :cond_a7
    sget-object v8, Lorg/pornaway/util/Constants;->ANDROID_SYSTEM_ETC_HOSTS:Ljava/lang/String;

    invoke-virtual {p1, v8}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v8

    if-eqz v8, :cond_d4

    .line 181
    new-instance v0, Lorg/sufficientlysecure/rootcommands/command/SimpleCommand;

    const/4 v8, 0x1

    new-array v8, v8, [Ljava/lang/String;

    const/4 v9, 0x0

    new-instance v10, Ljava/lang/StringBuilder;

    invoke-direct {v10}, Ljava/lang/StringBuilder;-><init>()V

    const-string v11, "rm -f "

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    aput-object v10, v8, v9

    invoke-direct {v0, v8}, Lorg/sufficientlysecure/rootcommands/command/SimpleCommand;-><init>([Ljava/lang/String;)V

    .line 182
    .local v0, "command":Lorg/sufficientlysecure/rootcommands/command/SimpleCommand;
    invoke-virtual {p2, v0}, Lorg/sufficientlysecure/rootcommands/Shell;->add(Lorg/sufficientlysecure/rootcommands/command/Command;)Lorg/sufficientlysecure/rootcommands/command/Command;

    move-result-object v8

    invoke-virtual {v8}, Lorg/sufficientlysecure/rootcommands/command/Command;->waitForFinish()V

    .line 185
    .end local v0    # "command":Lorg/sufficientlysecure/rootcommands/command/SimpleCommand;
    :cond_d4
    const/4 v8, 0x0

    const/4 v9, 0x0

    invoke-virtual {v6, v3, p1, v8, v9}, Lorg/sufficientlysecure/rootcommands/Toolbox;->copyFile(Ljava/lang/String;Ljava/lang/String;ZZ)Z

    move-result v8

    if-nez v8, :cond_10a

    .line 186
    new-instance v8, Lorg/pornaway/util/CommandException;

    invoke-direct {v8}, Lorg/pornaway/util/CommandException;-><init>()V

    throw v8
    :try_end_e2
    .catch Ljava/lang/Exception; {:try_start_91 .. :try_end_e2} :catch_e2
    .catchall {:try_start_91 .. :try_end_e2} :catchall_f0

    .line 193
    :catch_e2
    move-exception v1

    .line 194
    .local v1, "e":Ljava/lang/Exception;
    :try_start_e3
    const-string v8, "PornAway"

    const-string v9, "Exception!"

    invoke-static {v8, v9, v1}, Lorg/pornaway/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 196
    new-instance v8, Lorg/pornaway/util/CommandException;

    invoke-direct {v8}, Lorg/pornaway/util/CommandException;-><init>()V

    throw v8
    :try_end_f0
    .catchall {:try_start_e3 .. :try_end_f0} :catchall_f0

    .line 198
    .end local v1    # "e":Ljava/lang/Exception;
    :catchall_f0
    move-exception v8

    if-nez v7, :cond_109

    .line 200
    const-string v9, "PornAway"

    const-string v10, "Remounting back to RO..."

    invoke-static {v9, v10}, Lorg/pornaway/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 201
    const-string v9, "RO"

    invoke-virtual {v6, p1, v9}, Lorg/sufficientlysecure/rootcommands/Toolbox;->remount(Ljava/lang/String;Ljava/lang/String;)Z

    move-result v9

    if-nez v9, :cond_109

    .line 202
    const-string v9, "PornAway"

    const-string v10, "Remounting as RO failed! Probably not a problem!"

    invoke-static {v9, v10}, Lorg/pornaway/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)V

    :cond_109
    throw v8

    .line 190
    :cond_10a
    :try_start_10a
    new-instance v0, Lorg/sufficientlysecure/rootcommands/command/SimpleCommand;

    const/4 v8, 0x2

    new-array v8, v8, [Ljava/lang/String;

    const/4 v9, 0x0

    new-instance v10, Ljava/lang/StringBuilder;

    invoke-direct {v10}, Ljava/lang/StringBuilder;-><init>()V

    const-string v11, "chown 0:0 "

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    aput-object v10, v8, v9

    const/4 v9, 0x1

    new-instance v10, Ljava/lang/StringBuilder;

    invoke-direct {v10}, Ljava/lang/StringBuilder;-><init>()V

    const-string v11, "chmod 644 "

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    aput-object v10, v8, v9

    invoke-direct {v0, v8}, Lorg/sufficientlysecure/rootcommands/command/SimpleCommand;-><init>([Ljava/lang/String;)V

    .line 192
    .restart local v0    # "command":Lorg/sufficientlysecure/rootcommands/command/SimpleCommand;
    invoke-virtual {p2, v0}, Lorg/sufficientlysecure/rootcommands/Shell;->add(Lorg/sufficientlysecure/rootcommands/command/Command;)Lorg/sufficientlysecure/rootcommands/command/Command;

    move-result-object v8

    invoke-virtual {v8}, Lorg/sufficientlysecure/rootcommands/command/Command;->waitForFinish()V
    :try_end_145
    .catch Ljava/lang/Exception; {:try_start_10a .. :try_end_145} :catch_e2
    .catchall {:try_start_10a .. :try_end_145} :catchall_f0

    .line 198
    if-nez v7, :cond_15d

    .line 200
    const-string v8, "PornAway"

    const-string v9, "Remounting back to RO..."

    invoke-static {v8, v9}, Lorg/pornaway/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 201
    const-string v8, "RO"

    invoke-virtual {v6, p1, v8}, Lorg/sufficientlysecure/rootcommands/Toolbox;->remount(Ljava/lang/String;Ljava/lang/String;)Z

    move-result v8

    if-nez v8, :cond_15d

    .line 202
    const-string v8, "PornAway"

    const-string v9, "Remounting as RO failed! Probably not a problem!"

    invoke-static {v8, v9}, Lorg/pornaway/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 207
    :cond_15d
    return-void
.end method

.method public static createDirectories(Ljava/lang/String;Lorg/sufficientlysecure/rootcommands/Shell;)V
    .registers 9
    .param p0, "target"    # Ljava/lang/String;
    .param p1, "shell"    # Lorg/sufficientlysecure/rootcommands/Shell;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/pornaway/util/CommandException;
        }
    .end annotation

    .prologue
    .line 291
    :try_start_0
    new-instance v3, Ljava/io/File;

    invoke-direct {v3, p0}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3}, Ljava/io/File;->getParent()Ljava/lang/String;
    :try_end_8
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_8} :catch_38

    move-result-object v0

    .line 295
    .local v0, "directory":Ljava/lang/String;
    :try_start_9
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

    .line 298
    .local v2, "mkdirCommand":Lorg/sufficientlysecure/rootcommands/command/SimpleCommand;
    invoke-virtual {p1, v2}, Lorg/sufficientlysecure/rootcommands/Shell;->add(Lorg/sufficientlysecure/rootcommands/command/Command;)Lorg/sufficientlysecure/rootcommands/command/Command;

    move-result-object v3

    invoke-virtual {v3}, Lorg/sufficientlysecure/rootcommands/command/Command;->waitForFinish()V
    :try_end_2e
    .catch Ljava/lang/Exception; {:try_start_9 .. :try_end_2e} :catch_2f

    .line 307
    .end local v2    # "mkdirCommand":Lorg/sufficientlysecure/rootcommands/command/SimpleCommand;
    :goto_2e
    return-void

    .line 299
    :catch_2f
    move-exception v1

    .line 300
    .local v1, "e":Ljava/lang/Exception;
    :try_start_30
    const-string v3, "PornAway"

    const-string v4, "Mkdir Exception"

    invoke-static {v3, v4, v1}, Lorg/pornaway/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    :try_end_37
    .catch Ljava/lang/Exception; {:try_start_30 .. :try_end_37} :catch_38

    goto :goto_2e

    .line 302
    .end local v0    # "directory":Ljava/lang/String;
    .end local v1    # "e":Ljava/lang/Exception;
    :catch_38
    move-exception v1

    .line 303
    .restart local v1    # "e":Ljava/lang/Exception;
    const-string v3, "PornAway"

    const-string v4, "Exception!"

    invoke-static {v3, v4, v1}, Lorg/pornaway/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 305
    new-instance v3, Lorg/pornaway/util/CommandException;

    invoke-direct {v3}, Lorg/pornaway/util/CommandException;-><init>()V

    throw v3
.end method

.method public static createSymlink(Ljava/lang/String;)V
    .registers 9
    .param p0, "target"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/pornaway/util/RemountException;,
            Lorg/pornaway/util/CommandException;
        }
    .end annotation

    .prologue
    .line 217
    :try_start_0
    invoke-static {}, Lorg/sufficientlysecure/rootcommands/Shell;->startRootShell()Lorg/sufficientlysecure/rootcommands/Shell;
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_3} :catch_19

    move-result-object v2

    .line 221
    .local v2, "rootShell":Lorg/sufficientlysecure/rootcommands/Shell;
    new-instance v3, Lorg/sufficientlysecure/rootcommands/Toolbox;

    invoke-direct {v3, v2}, Lorg/sufficientlysecure/rootcommands/Toolbox;-><init>(Lorg/sufficientlysecure/rootcommands/Shell;)V

    .line 224
    .local v3, "tb":Lorg/sufficientlysecure/rootcommands/Toolbox;
    sget-object v4, Lorg/pornaway/util/Constants;->ANDROID_SYSTEM_ETC_HOSTS:Ljava/lang/String;

    const-string v5, "RW"

    invoke-virtual {v3, v4, v5}, Lorg/sufficientlysecure/rootcommands/Toolbox;->remount(Ljava/lang/String;Ljava/lang/String;)Z

    move-result v4

    if-nez v4, :cond_22

    .line 225
    new-instance v4, Lorg/pornaway/util/RemountException;

    invoke-direct {v4}, Lorg/pornaway/util/RemountException;-><init>()V

    throw v4

    .line 218
    .end local v2    # "rootShell":Lorg/sufficientlysecure/rootcommands/Shell;
    .end local v3    # "tb":Lorg/sufficientlysecure/rootcommands/Toolbox;
    :catch_19
    move-exception v1

    .line 219
    .local v1, "e":Ljava/lang/Exception;
    new-instance v4, Lorg/pornaway/util/CommandException;

    const-string v5, "Problem opening root shell!"

    invoke-direct {v4, v5}, Lorg/pornaway/util/CommandException;-><init>(Ljava/lang/String;)V

    throw v4

    .line 231
    .end local v1    # "e":Ljava/lang/Exception;
    .restart local v2    # "rootShell":Lorg/sufficientlysecure/rootcommands/Shell;
    .restart local v3    # "tb":Lorg/sufficientlysecure/rootcommands/Toolbox;
    :cond_22
    :try_start_22
    new-instance v0, Lorg/sufficientlysecure/rootcommands/command/SimpleCommand;

    const/4 v4, 0x5

    new-array v4, v4, [Ljava/lang/String;

    const/4 v5, 0x0

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "rm -f "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    sget-object v7, Lorg/pornaway/util/Constants;->ANDROID_SYSTEM_ETC_HOSTS:Ljava/lang/String;

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

    sget-object v7, Lorg/pornaway/util/Constants;->ANDROID_SYSTEM_ETC_HOSTS:Ljava/lang/String;

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

    .line 239
    .local v0, "command":Lorg/sufficientlysecure/rootcommands/command/SimpleCommand;
    invoke-virtual {v2, v0}, Lorg/sufficientlysecure/rootcommands/Shell;->add(Lorg/sufficientlysecure/rootcommands/command/Command;)Lorg/sufficientlysecure/rootcommands/command/Command;

    move-result-object v4

    invoke-virtual {v4}, Lorg/sufficientlysecure/rootcommands/command/Command;->waitForFinish()V
    :try_end_ad
    .catch Ljava/lang/Exception; {:try_start_22 .. :try_end_ad} :catch_c1
    .catchall {:try_start_22 .. :try_end_ad} :catchall_c8

    .line 244
    sget-object v4, Lorg/pornaway/util/Constants;->ANDROID_SYSTEM_ETC_HOSTS:Ljava/lang/String;

    const-string v5, "RO"

    invoke-virtual {v3, v4, v5}, Lorg/sufficientlysecure/rootcommands/Toolbox;->remount(Ljava/lang/String;Ljava/lang/String;)Z

    .line 247
    :try_start_b4
    invoke-virtual {v2}, Lorg/sufficientlysecure/rootcommands/Shell;->close()V
    :try_end_b7
    .catch Ljava/io/IOException; {:try_start_b4 .. :try_end_b7} :catch_b8

    .line 252
    return-void

    .line 248
    :catch_b8
    move-exception v1

    .line 249
    .local v1, "e":Ljava/io/IOException;
    new-instance v4, Lorg/pornaway/util/CommandException;

    const-string v5, "Problem closing root shell!"

    invoke-direct {v4, v5}, Lorg/pornaway/util/CommandException;-><init>(Ljava/lang/String;)V

    throw v4

    .line 240
    .end local v0    # "command":Lorg/sufficientlysecure/rootcommands/command/SimpleCommand;
    .end local v1    # "e":Ljava/io/IOException;
    :catch_c1
    move-exception v1

    .line 241
    .local v1, "e":Ljava/lang/Exception;
    :try_start_c2
    new-instance v4, Lorg/pornaway/util/CommandException;

    invoke-direct {v4}, Lorg/pornaway/util/CommandException;-><init>()V

    throw v4
    :try_end_c8
    .catchall {:try_start_c2 .. :try_end_c8} :catchall_c8

    .line 244
    .end local v1    # "e":Ljava/lang/Exception;
    :catchall_c8
    move-exception v4

    sget-object v5, Lorg/pornaway/util/Constants;->ANDROID_SYSTEM_ETC_HOSTS:Ljava/lang/String;

    const-string v6, "RO"

    invoke-virtual {v3, v5, v6}, Lorg/sufficientlysecure/rootcommands/Toolbox;->remount(Ljava/lang/String;Ljava/lang/String;)Z

    .line 247
    :try_start_d0
    invoke-virtual {v2}, Lorg/sufficientlysecure/rootcommands/Shell;->close()V
    :try_end_d3
    .catch Ljava/io/IOException; {:try_start_d0 .. :try_end_d3} :catch_d4

    .line 249
    throw v4

    .line 248
    :catch_d4
    move-exception v1

    .line 249
    .local v1, "e":Ljava/io/IOException;
    new-instance v4, Lorg/pornaway/util/CommandException;

    const-string v5, "Problem closing root shell!"

    invoke-direct {v4, v5}, Lorg/pornaway/util/CommandException;-><init>(Ljava/lang/String;)V

    throw v4
.end method

.method public static hasEnoughSpaceOnPartition(Ljava/lang/String;J)Z
    .registers 16
    .param p0, "target"    # Ljava/lang/String;
    .param p1, "size"    # J

    .prologue
    const/4 v8, 0x1

    .line 52
    :try_start_1
    new-instance v7, Landroid/os/StatFs;

    invoke-direct {v7, p0}, Landroid/os/StatFs;-><init>(Ljava/lang/String;)V

    .line 53
    .local v7, "stat":Landroid/os/StatFs;
    invoke-virtual {v7}, Landroid/os/StatFs;->getBlockSize()I

    move-result v9

    int-to-long v4, v9

    .line 54
    .local v4, "blockSize":J
    invoke-virtual {v7}, Landroid/os/StatFs;->getAvailableBlocks()I

    move-result v9

    int-to-long v0, v9

    .line 55
    .local v0, "availableBlocks":J
    mul-long v2, v0, v4

    .line 57
    .local v2, "availableSpace":J
    const-string v9, "PornAway"

    new-instance v10, Ljava/lang/StringBuilder;

    invoke-direct {v10}, Ljava/lang/StringBuilder;-><init>()V

    const-string v11, "Checking for enough space: Target: "

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    const-string v11, " size: "

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10, p1, p2}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v10

    const-string v11, ", availableSpace: "

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10, v2, v3}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-static {v9, v10}, Lorg/pornaway/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 60
    cmp-long v9, p1, v2

    if-gez v9, :cond_43

    .line 70
    .end local v0    # "availableBlocks":J
    .end local v2    # "availableSpace":J
    .end local v4    # "blockSize":J
    .end local v7    # "stat":Landroid/os/StatFs;
    :goto_42
    return v8

    .line 63
    .restart local v0    # "availableBlocks":J
    .restart local v2    # "availableSpace":J
    .restart local v4    # "blockSize":J
    .restart local v7    # "stat":Landroid/os/StatFs;
    :cond_43
    const-string v9, "PornAway"

    const-string v10, "Not enough space on partition!"

    invoke-static {v9, v10}, Lorg/pornaway/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_4a
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_4a} :catch_4c

    .line 64
    const/4 v8, 0x0

    goto :goto_42

    .line 66
    .end local v0    # "availableBlocks":J
    .end local v2    # "availableSpace":J
    .end local v4    # "blockSize":J
    .end local v7    # "stat":Landroid/os/StatFs;
    :catch_4c
    move-exception v6

    .line 69
    .local v6, "e":Ljava/lang/Exception;
    const-string v9, "PornAway"

    const-string v10, "Problem while getting available space on partition!"

    invoke-static {v9, v10, v6}, Lorg/pornaway/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_42
.end method

.method public static isApnProxySet(Landroid/content/Context;)Z
    .registers 14
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 318
    const/4 v12, 0x0

    .line 321
    .local v12, "result":Z
    :try_start_1
    const-string v0, "content://telephony/carriers/preferapn"

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    .line 322
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

    .line 324
    .local v2, "projection":[Ljava/lang/String;
    invoke-virtual {p0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    const/4 v3, 0x0

    const/4 v4, 0x0

    const/4 v5, 0x0

    invoke-virtual/range {v0 .. v5}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v6

    .line 328
    .local v6, "cursor":Landroid/database/Cursor;
    if-eqz v6, :cond_6f

    .line 330
    const-string v0, "name"

    invoke-interface {v6, v0}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v9

    .line 331
    .local v9, "nameColumn":I
    const-string v0, "proxy"

    invoke-interface {v6, v0}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v11

    .line 333
    .local v11, "proxyColumn":I
    invoke-interface {v6}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v0

    if-eqz v0, :cond_6b

    .line 335
    invoke-interface {v6, v9}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v8

    .line 336
    .local v8, "name":Ljava/lang/String;
    invoke-interface {v6, v11}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v10

    .line 338
    .local v10, "proxy":Ljava/lang/String;
    const-string v0, "PornAway"

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

    invoke-static {v0, v3}, Lorg/pornaway/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 341
    const-string v0, "\\s*"

    invoke-virtual {v10, v0}, Ljava/lang/String;->matches(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_6b

    .line 342
    const/4 v12, 0x1

    .line 346
    .end local v8    # "name":Ljava/lang/String;
    .end local v10    # "proxy":Ljava/lang/String;
    :cond_6b
    invoke-interface {v6}, Landroid/database/Cursor;->close()V

    .line 355
    .end local v1    # "defaultApnUri":Landroid/net/Uri;
    .end local v2    # "projection":[Ljava/lang/String;
    .end local v6    # "cursor":Landroid/database/Cursor;
    .end local v9    # "nameColumn":I
    .end local v11    # "proxyColumn":I
    :goto_6e
    return v12

    .line 348
    .restart local v1    # "defaultApnUri":Landroid/net/Uri;
    .restart local v2    # "projection":[Ljava/lang/String;
    .restart local v6    # "cursor":Landroid/database/Cursor;
    :cond_6f
    const-string v0, "PornAway"

    const-string v3, "Could not get APN cursor!"

    invoke-static {v0, v3}, Lorg/pornaway/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_76
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_76} :catch_77

    goto :goto_6e

    .line 350
    .end local v1    # "defaultApnUri":Landroid/net/Uri;
    .end local v2    # "projection":[Ljava/lang/String;
    .end local v6    # "cursor":Landroid/database/Cursor;
    :catch_77
    move-exception v7

    .line 351
    .local v7, "e":Ljava/lang/Exception;
    const-string v0, "PornAway"

    const-string v3, "Error while getting default APN!"

    invoke-static {v0, v3, v7}, Lorg/pornaway/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_6e
.end method

.method public static isHostsFileCorrect(Ljava/lang/String;)Z
    .registers 12
    .param p0, "target"    # Ljava/lang/String;

    .prologue
    .line 97
    const/4 v5, 0x0

    .line 100
    .local v5, "status":Z
    const/4 v6, 0x0

    .line 104
    .local v6, "stream":Ljava/io/InputStream;
    :try_start_2
    new-instance v2, Ljava/io/File;

    invoke-direct {v2, p0}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 106
    .local v2, "file":Ljava/io/File;
    new-instance v7, Ljava/io/FileInputStream;

    invoke-direct {v7, v2}, Ljava/io/FileInputStream;-><init>(Ljava/io/File;)V
    :try_end_c
    .catch Ljava/io/FileNotFoundException; {:try_start_2 .. :try_end_c} :catch_53
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_c} :catch_6b
    .catchall {:try_start_2 .. :try_end_c} :catchall_83

    .line 107
    .end local v6    # "stream":Ljava/io/InputStream;
    .local v7, "stream":Ljava/io/InputStream;
    :try_start_c
    new-instance v4, Ljava/io/InputStreamReader;

    invoke-direct {v4, v7}, Ljava/io/InputStreamReader;-><init>(Ljava/io/InputStream;)V

    .line 108
    .local v4, "in":Ljava/io/InputStreamReader;
    new-instance v0, Ljava/io/BufferedReader;

    invoke-direct {v0, v4}, Ljava/io/BufferedReader;-><init>(Ljava/io/Reader;)V

    .line 110
    .local v0, "br":Ljava/io/BufferedReader;
    invoke-virtual {v0}, Ljava/io/BufferedReader;->readLine()Ljava/lang/String;

    move-result-object v3

    .line 112
    .local v3, "firstLine":Ljava/lang/String;
    const-string v8, "PornAway"

    new-instance v9, Ljava/lang/StringBuilder;

    invoke-direct {v9}, Ljava/lang/StringBuilder;-><init>()V

    const-string v10, "First line of "

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    const-string v10, ": "

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-static {v8, v9}, Lorg/pornaway/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 114
    const-string v8, "# This hosts file has been generated by PornAway on:"

    invoke-virtual {v3, v8}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    :try_end_41
    .catch Ljava/io/FileNotFoundException; {:try_start_c .. :try_end_41} :catch_99
    .catch Ljava/lang/Exception; {:try_start_c .. :try_end_41} :catch_96
    .catchall {:try_start_c .. :try_end_41} :catchall_93

    move-result v5

    .line 122
    if-eqz v7, :cond_9c

    .line 124
    :try_start_44
    invoke-virtual {v7}, Ljava/io/InputStream;->close()V
    :try_end_47
    .catch Ljava/io/IOException; {:try_start_44 .. :try_end_47} :catch_49

    move-object v6, v7

    .line 131
    .end local v0    # "br":Ljava/io/BufferedReader;
    .end local v2    # "file":Ljava/io/File;
    .end local v3    # "firstLine":Ljava/lang/String;
    .end local v4    # "in":Ljava/io/InputStreamReader;
    .end local v7    # "stream":Ljava/io/InputStream;
    .restart local v6    # "stream":Ljava/io/InputStream;
    :cond_48
    :goto_48
    return v5

    .line 125
    .end local v6    # "stream":Ljava/io/InputStream;
    .restart local v0    # "br":Ljava/io/BufferedReader;
    .restart local v2    # "file":Ljava/io/File;
    .restart local v3    # "firstLine":Ljava/lang/String;
    .restart local v4    # "in":Ljava/io/InputStreamReader;
    .restart local v7    # "stream":Ljava/io/InputStream;
    :catch_49
    move-exception v1

    .line 126
    .local v1, "e":Ljava/io/IOException;
    const-string v8, "PornAway"

    const-string v9, "Exception"

    invoke-static {v8, v9, v1}, Lorg/pornaway/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    move-object v6, v7

    .line 127
    .end local v7    # "stream":Ljava/io/InputStream;
    .restart local v6    # "stream":Ljava/io/InputStream;
    goto :goto_48

    .line 115
    .end local v0    # "br":Ljava/io/BufferedReader;
    .end local v1    # "e":Ljava/io/IOException;
    .end local v2    # "file":Ljava/io/File;
    .end local v3    # "firstLine":Ljava/lang/String;
    .end local v4    # "in":Ljava/io/InputStreamReader;
    :catch_53
    move-exception v1

    .line 116
    .local v1, "e":Ljava/io/FileNotFoundException;
    :goto_54
    :try_start_54
    const-string v8, "PornAway"

    const-string v9, "FileNotFoundException"

    invoke-static {v8, v9, v1}, Lorg/pornaway/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    :try_end_5b
    .catchall {:try_start_54 .. :try_end_5b} :catchall_83

    .line 117
    const/4 v5, 0x1

    .line 122
    if-eqz v6, :cond_48

    .line 124
    :try_start_5e
    invoke-virtual {v6}, Ljava/io/InputStream;->close()V
    :try_end_61
    .catch Ljava/io/IOException; {:try_start_5e .. :try_end_61} :catch_62

    goto :goto_48

    .line 125
    :catch_62
    move-exception v1

    .line 126
    .local v1, "e":Ljava/io/IOException;
    const-string v8, "PornAway"

    const-string v9, "Exception"

    invoke-static {v8, v9, v1}, Lorg/pornaway/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_48

    .line 118
    .end local v1    # "e":Ljava/io/IOException;
    :catch_6b
    move-exception v1

    .line 119
    .local v1, "e":Ljava/lang/Exception;
    :goto_6c
    :try_start_6c
    const-string v8, "PornAway"

    const-string v9, "Exception: "

    invoke-static {v8, v9, v1}, Lorg/pornaway/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    :try_end_73
    .catchall {:try_start_6c .. :try_end_73} :catchall_83

    .line 120
    const/4 v5, 0x0

    .line 122
    if-eqz v6, :cond_48

    .line 124
    :try_start_76
    invoke-virtual {v6}, Ljava/io/InputStream;->close()V
    :try_end_79
    .catch Ljava/io/IOException; {:try_start_76 .. :try_end_79} :catch_7a

    goto :goto_48

    .line 125
    :catch_7a
    move-exception v1

    .line 126
    .local v1, "e":Ljava/io/IOException;
    const-string v8, "PornAway"

    const-string v9, "Exception"

    invoke-static {v8, v9, v1}, Lorg/pornaway/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_48

    .line 122
    .end local v1    # "e":Ljava/io/IOException;
    :catchall_83
    move-exception v8

    :goto_84
    if-eqz v6, :cond_89

    .line 124
    :try_start_86
    invoke-virtual {v6}, Ljava/io/InputStream;->close()V
    :try_end_89
    .catch Ljava/io/IOException; {:try_start_86 .. :try_end_89} :catch_8a

    .line 127
    :cond_89
    :goto_89
    throw v8

    .line 125
    :catch_8a
    move-exception v1

    .line 126
    .restart local v1    # "e":Ljava/io/IOException;
    const-string v9, "PornAway"

    const-string v10, "Exception"

    invoke-static {v9, v10, v1}, Lorg/pornaway/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_89

    .line 122
    .end local v1    # "e":Ljava/io/IOException;
    .end local v6    # "stream":Ljava/io/InputStream;
    .restart local v2    # "file":Ljava/io/File;
    .restart local v7    # "stream":Ljava/io/InputStream;
    :catchall_93
    move-exception v8

    move-object v6, v7

    .end local v7    # "stream":Ljava/io/InputStream;
    .restart local v6    # "stream":Ljava/io/InputStream;
    goto :goto_84

    .line 118
    .end local v6    # "stream":Ljava/io/InputStream;
    .restart local v7    # "stream":Ljava/io/InputStream;
    :catch_96
    move-exception v1

    move-object v6, v7

    .end local v7    # "stream":Ljava/io/InputStream;
    .restart local v6    # "stream":Ljava/io/InputStream;
    goto :goto_6c

    .line 115
    .end local v6    # "stream":Ljava/io/InputStream;
    .restart local v7    # "stream":Ljava/io/InputStream;
    :catch_99
    move-exception v1

    move-object v6, v7

    .end local v7    # "stream":Ljava/io/InputStream;
    .restart local v6    # "stream":Ljava/io/InputStream;
    goto :goto_54

    .end local v6    # "stream":Ljava/io/InputStream;
    .restart local v0    # "br":Ljava/io/BufferedReader;
    .restart local v3    # "firstLine":Ljava/lang/String;
    .restart local v4    # "in":Ljava/io/InputStreamReader;
    .restart local v7    # "stream":Ljava/io/InputStream;
    :cond_9c
    move-object v6, v7

    .end local v7    # "stream":Ljava/io/InputStream;
    .restart local v6    # "stream":Ljava/io/InputStream;
    goto :goto_48
.end method

.method public static isSymlinkCorrect(Ljava/lang/String;Lorg/sufficientlysecure/rootcommands/Shell;)Z
    .registers 9
    .param p0, "target"    # Ljava/lang/String;
    .param p1, "shell"    # Lorg/sufficientlysecure/rootcommands/Shell;

    .prologue
    const/4 v3, 0x0

    .line 260
    const-string v4, "PornAway"

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

    invoke-static {v4, v5}, Lorg/pornaway/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 263
    new-instance v2, Lorg/sufficientlysecure/rootcommands/Toolbox;

    invoke-direct {v2, p1}, Lorg/sufficientlysecure/rootcommands/Toolbox;-><init>(Lorg/sufficientlysecure/rootcommands/Shell;)V

    .line 266
    .local v2, "tb":Lorg/sufficientlysecure/rootcommands/Toolbox;
    :try_start_24
    sget-object v4, Lorg/pornaway/util/Constants;->ANDROID_SYSTEM_ETC_HOSTS:Ljava/lang/String;

    invoke-virtual {v2, v4}, Lorg/sufficientlysecure/rootcommands/Toolbox;->getSymlink(Ljava/lang/String;)Ljava/lang/String;
    :try_end_29
    .catch Ljava/lang/Exception; {:try_start_24 .. :try_end_29} :catch_56

    move-result-object v1

    .line 272
    .local v1, "symlink":Ljava/lang/String;
    const-string v4, "PornAway"

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

    invoke-static {v4, v5}, Lorg/pornaway/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 274
    if-eqz v1, :cond_55

    invoke-virtual {v1, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_55

    .line 275
    const/4 v3, 0x1

    .line 277
    .end local v1    # "symlink":Ljava/lang/String;
    :cond_55
    :goto_55
    return v3

    .line 267
    :catch_56
    move-exception v0

    .line 268
    .local v0, "e":Ljava/lang/Exception;
    const-string v4, "PornAway"

    const-string v5, "Problem getting symlink!"

    invoke-static {v4, v5, v0}, Lorg/pornaway/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_55
.end method

.method public static isWritable(Lorg/sufficientlysecure/rootcommands/Shell;Ljava/lang/String;)Z
    .registers 9
    .param p0, "shell"    # Lorg/sufficientlysecure/rootcommands/Shell;
    .param p1, "path"    # Ljava/lang/String;

    .prologue
    const/4 v2, 0x1

    const/4 v3, 0x0

    .line 81
    new-instance v1, Lorg/sufficientlysecure/rootcommands/command/SimpleCommand;

    new-array v4, v2, [Ljava/lang/String;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "touch "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v4, v3

    invoke-direct {v1, v4}, Lorg/sufficientlysecure/rootcommands/command/SimpleCommand;-><init>([Ljava/lang/String;)V

    .line 83
    .local v1, "touchCommand":Lorg/sufficientlysecure/rootcommands/command/SimpleCommand;
    :try_start_1e
    invoke-virtual {p0, v1}, Lorg/sufficientlysecure/rootcommands/Shell;->add(Lorg/sufficientlysecure/rootcommands/command/Command;)Lorg/sufficientlysecure/rootcommands/command/Command;

    move-result-object v4

    invoke-virtual {v4}, Lorg/sufficientlysecure/rootcommands/command/Command;->waitForFinish()V
    :try_end_25
    .catch Ljava/lang/Exception; {:try_start_1e .. :try_end_25} :catch_2c

    .line 88
    invoke-virtual {v1}, Lorg/sufficientlysecure/rootcommands/command/SimpleCommand;->getExitCode()I

    move-result v4

    if-nez v4, :cond_36

    :goto_2b
    return v2

    .line 84
    :catch_2c
    move-exception v0

    .line 85
    .local v0, "e":Ljava/lang/Exception;
    const-string v2, "PornAway"

    const-string v4, "Problem while checking if writable."

    invoke-static {v2, v4, v0}, Lorg/pornaway/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    move v2, v3

    .line 86
    goto :goto_2b

    .end local v0    # "e":Ljava/lang/Exception;
    :cond_36
    move v2, v3

    .line 88
    goto :goto_2b
.end method
