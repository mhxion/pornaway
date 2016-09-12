.class public Lorg/adaway/util/TcpdumpUtils;
.super Ljava/lang/Object;
.source "TcpdumpUtils.java"


# direct methods
.method public constructor <init>()V
    .registers 1

    .prologue
    .line 35
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static deleteLog(Landroid/content/Context;)V
    .registers 9
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 89
    :try_start_0
    invoke-virtual {p0}, Landroid/content/Context;->getCacheDir()Ljava/io/File;

    move-result-object v6

    invoke-virtual {v6}, Ljava/io/File;->getCanonicalPath()Ljava/lang/String;

    move-result-object v0

    .line 90
    .local v0, "cachePath":Ljava/lang/String;
    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v6, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    sget-object v7, Lorg/adaway/util/Constants;->FILE_SEPERATOR:Ljava/lang/String;

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, "dns_log.txt"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    .line 92
    .local v3, "filePath":Ljava/lang/String;
    new-instance v2, Ljava/io/File;

    invoke-direct {v2, v3}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 93
    .local v2, "file":Ljava/io/File;
    invoke-virtual {v2}, Ljava/io/File;->exists()Z

    move-result v6

    if-eqz v6, :cond_41

    .line 94
    new-instance v4, Ljava/io/FileOutputStream;

    const/4 v6, 0x0

    invoke-direct {v4, v2, v6}, Ljava/io/FileOutputStream;-><init>(Ljava/io/File;Z)V

    .line 95
    .local v4, "fileStream":Ljava/io/FileOutputStream;
    invoke-virtual {v4}, Ljava/io/FileOutputStream;->close()V

    .line 96
    const v6, 0x7f0800ae

    const/4 v7, 0x0

    invoke-static {p0, v6, v7}, Landroid/widget/Toast;->makeText(Landroid/content/Context;II)Landroid/widget/Toast;

    move-result-object v5

    .line 98
    .local v5, "toast":Landroid/widget/Toast;
    invoke-virtual {v5}, Landroid/widget/Toast;->show()V

    .line 105
    .end local v0    # "cachePath":Ljava/lang/String;
    .end local v2    # "file":Ljava/io/File;
    .end local v3    # "filePath":Ljava/lang/String;
    .end local v4    # "fileStream":Ljava/io/FileOutputStream;
    .end local v5    # "toast":Landroid/widget/Toast;
    :goto_40
    return-void

    .line 100
    .restart local v0    # "cachePath":Ljava/lang/String;
    .restart local v2    # "file":Ljava/io/File;
    .restart local v3    # "filePath":Ljava/lang/String;
    :cond_41
    const-string v6, "AdAway"

    const-string v7, "Tcpdump log is not existing!"

    invoke-static {v6, v7}, Lorg/adaway/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_48
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_48} :catch_49

    goto :goto_40

    .line 102
    .end local v0    # "cachePath":Ljava/lang/String;
    .end local v2    # "file":Ljava/io/File;
    .end local v3    # "filePath":Ljava/lang/String;
    :catch_49
    move-exception v1

    .line 103
    .local v1, "e":Ljava/lang/Exception;
    const-string v6, "AdAway"

    const-string v7, "Error truncating file!"

    invoke-static {v6, v7, v1}, Lorg/adaway/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_40
.end method

.method public static isTcpdumpRunning(Lorg/sufficientlysecure/rootcommands/Shell;)Z
    .registers 6
    .param p0, "shell"    # Lorg/sufficientlysecure/rootcommands/Shell;

    .prologue
    const/4 v2, 0x0

    .line 128
    :try_start_1
    new-instance v1, Lorg/sufficientlysecure/rootcommands/Toolbox;

    invoke-direct {v1, p0}, Lorg/sufficientlysecure/rootcommands/Toolbox;-><init>(Lorg/sufficientlysecure/rootcommands/Shell;)V

    .line 130
    .local v1, "tb":Lorg/sufficientlysecure/rootcommands/Toolbox;
    const-string v3, "tcpdump"

    invoke-virtual {v1, v3}, Lorg/sufficientlysecure/rootcommands/Toolbox;->isBinaryRunning(Ljava/lang/String;)Z
    :try_end_b
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_b} :catch_10

    move-result v3

    if-eqz v3, :cond_f

    .line 131
    const/4 v2, 0x1

    .line 137
    .end local v1    # "tb":Lorg/sufficientlysecure/rootcommands/Toolbox;
    :cond_f
    :goto_f
    return v2

    .line 135
    :catch_10
    move-exception v0

    .line 136
    .local v0, "e":Ljava/lang/Exception;
    const-string v3, "AdAway"

    const-string v4, "Exception while checking tcpdump"

    invoke-static {v3, v4, v0}, Lorg/adaway/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_f
.end method

.method public static startTcpdump(Landroid/content/Context;Lorg/sufficientlysecure/rootcommands/Shell;)Z
    .registers 11
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "shell"    # Lorg/sufficientlysecure/rootcommands/Shell;

    .prologue
    const/4 v6, 0x0

    .line 44
    const-string v7, "AdAway"

    const-string v8, "Starting tcpdump..."

    invoke-static {v7, v8}, Lorg/adaway/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 46
    const/4 v0, 0x0

    .line 48
    .local v0, "cachePath":Ljava/lang/String;
    :try_start_9
    invoke-virtual {p0}, Landroid/content/Context;->getCacheDir()Ljava/io/File;

    move-result-object v7

    invoke-virtual {v7}, Ljava/io/File;->getCanonicalPath()Ljava/lang/String;

    move-result-object v0

    .line 49
    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v7, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    sget-object v8, Lorg/adaway/util/Constants;->FILE_SEPERATOR:Ljava/lang/String;

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v8, "dns_log.txt"

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    .line 52
    .local v3, "filePath":Ljava/lang/String;
    new-instance v2, Ljava/io/File;

    invoke-direct {v2, v3}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 53
    .local v2, "file":Ljava/io/File;
    invoke-virtual {v2}, Ljava/io/File;->createNewFile()Z
    :try_end_32
    .catch Ljava/io/IOException; {:try_start_9 .. :try_end_32} :catch_67

    .line 66
    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, "-i any -p -l -v -t -s 512 \'udp dst port 53\' >> "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    sget-object v8, Lorg/adaway/util/Constants;->FILE_SEPERATOR:Ljava/lang/String;

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v8, "dns_log.txt"

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v8, " 2>&1 &"

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    .line 69
    .local v4, "parameters":Ljava/lang/String;
    new-instance v5, Lorg/sufficientlysecure/rootcommands/command/SimpleExecutableCommand;

    const-string v7, "tcpdump"

    invoke-direct {v5, p0, v7, v4}, Lorg/sufficientlysecure/rootcommands/command/SimpleExecutableCommand;-><init>(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    .line 73
    .local v5, "tcpdumpCommand":Lorg/sufficientlysecure/rootcommands/command/SimpleExecutableCommand;
    :try_start_5e
    invoke-virtual {p1, v5}, Lorg/sufficientlysecure/rootcommands/Shell;->add(Lorg/sufficientlysecure/rootcommands/command/Command;)Lorg/sufficientlysecure/rootcommands/command/Command;

    move-result-object v7

    invoke-virtual {v7}, Lorg/sufficientlysecure/rootcommands/command/Command;->waitForFinish()V
    :try_end_65
    .catch Ljava/lang/Exception; {:try_start_5e .. :try_end_65} :catch_70

    .line 79
    const/4 v6, 0x1

    .end local v2    # "file":Ljava/io/File;
    .end local v3    # "filePath":Ljava/lang/String;
    .end local v4    # "parameters":Ljava/lang/String;
    .end local v5    # "tcpdumpCommand":Lorg/sufficientlysecure/rootcommands/command/SimpleExecutableCommand;
    :goto_66
    return v6

    .line 54
    :catch_67
    move-exception v1

    .line 55
    .local v1, "e":Ljava/io/IOException;
    const-string v7, "AdAway"

    const-string v8, "Problem while getting cache directory!"

    invoke-static {v7, v8, v1}, Lorg/adaway/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_66

    .line 74
    .end local v1    # "e":Ljava/io/IOException;
    .restart local v2    # "file":Ljava/io/File;
    .restart local v3    # "filePath":Ljava/lang/String;
    .restart local v4    # "parameters":Ljava/lang/String;
    .restart local v5    # "tcpdumpCommand":Lorg/sufficientlysecure/rootcommands/command/SimpleExecutableCommand;
    :catch_70
    move-exception v1

    .line 75
    .local v1, "e":Ljava/lang/Exception;
    const-string v7, "AdAway"

    const-string v8, "Exception while starting tcpdump"

    invoke-static {v7, v8, v1}, Lorg/adaway/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_66
.end method

.method public static stopTcpdump(Landroid/content/Context;Lorg/sufficientlysecure/rootcommands/Shell;)V
    .registers 6
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "shell"    # Lorg/sufficientlysecure/rootcommands/Shell;

    .prologue
    .line 114
    :try_start_0
    new-instance v1, Lorg/sufficientlysecure/rootcommands/Toolbox;

    invoke-direct {v1, p1}, Lorg/sufficientlysecure/rootcommands/Toolbox;-><init>(Lorg/sufficientlysecure/rootcommands/Shell;)V

    .line 115
    .local v1, "tb":Lorg/sufficientlysecure/rootcommands/Toolbox;
    const-string v2, "tcpdump"

    invoke-virtual {v1, v2}, Lorg/sufficientlysecure/rootcommands/Toolbox;->killAllExecutable(Ljava/lang/String;)Z
    :try_end_a
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_a} :catch_b

    .line 119
    .end local v1    # "tb":Lorg/sufficientlysecure/rootcommands/Toolbox;
    :goto_a
    return-void

    .line 116
    :catch_b
    move-exception v0

    .line 117
    .local v0, "e":Ljava/lang/Exception;
    const-string v2, "AdAway"

    const-string v3, "Exception while killing tcpdump"

    invoke-static {v2, v3, v0}, Lorg/adaway/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_a
.end method
