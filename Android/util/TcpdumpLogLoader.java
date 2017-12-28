.class public Lorg/pornaway/util/TcpdumpLogLoader;
.super Landroid/support/v4/content/AsyncTaskLoader;
.source "TcpdumpLogLoader.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/support/v4/content/AsyncTaskLoader",
        "<",
        "Ljava/util/ArrayList",
        "<",
        "Ljava/lang/String;",
        ">;>;"
    }
.end annotation


# instance fields
.field context:Landroid/content/Context;

.field mItems:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .registers 2
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 45
    invoke-direct {p0, p1}, Landroid/support/v4/content/AsyncTaskLoader;-><init>(Landroid/content/Context;)V

    .line 47
    iput-object p1, p0, Lorg/pornaway/util/TcpdumpLogLoader;->context:Landroid/content/Context;

    .line 48
    return-void
.end method


# virtual methods
.method public bridge synthetic deliverResult(Ljava/lang/Object;)V
    .registers 2

    .prologue
    .line 39
    check-cast p1, Ljava/util/ArrayList;

    invoke-virtual {p0, p1}, Lorg/pornaway/util/TcpdumpLogLoader;->deliverResult(Ljava/util/ArrayList;)V

    return-void
.end method

.method public deliverResult(Ljava/util/ArrayList;)V
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 119
    .local p1, "data":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    invoke-super {p0, p1}, Landroid/support/v4/content/AsyncTaskLoader;->deliverResult(Ljava/lang/Object;)V

    .line 120
    return-void
.end method

.method public bridge synthetic loadInBackground()Ljava/lang/Object;
    .registers 2

    .prologue
    .line 39
    invoke-virtual {p0}, Lorg/pornaway/util/TcpdumpLogLoader;->loadInBackground()Ljava/util/ArrayList;

    move-result-object v0

    return-object v0
.end method

.method public loadInBackground()Ljava/util/ArrayList;
    .registers 15
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 53
    new-instance v10, Ljava/util/HashSet;

    invoke-direct {v10}, Ljava/util/HashSet;-><init>()V

    .line 56
    .local v10, "set":Ljava/util/HashSet;, "Ljava/util/HashSet<Ljava/lang/String;>;"
    :try_start_5
    iget-object v11, p0, Lorg/pornaway/util/TcpdumpLogLoader;->context:Landroid/content/Context;

    invoke-virtual {v11}, Landroid/content/Context;->getCacheDir()Ljava/io/File;

    move-result-object v11

    invoke-virtual {v11}, Ljava/io/File;->getCanonicalPath()Ljava/lang/String;

    move-result-object v0

    .line 57
    .local v0, "cachePath":Ljava/lang/String;
    new-instance v11, Ljava/lang/StringBuilder;

    invoke-direct {v11}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v11, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    sget-object v12, Lorg/pornaway/util/Constants;->FILE_SEPERATOR:Ljava/lang/String;

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    const-string v12, "dns_log.txt"

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v11}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    .line 59
    .local v3, "filePath":Ljava/lang/String;
    new-instance v2, Ljava/io/File;

    invoke-direct {v2, v3}, Ljava/io/File;-><init>(Ljava/lang/String;)V
    :try_end_2d
    .catch Ljava/io/IOException; {:try_start_5 .. :try_end_2d} :catch_7c

    .line 62
    .local v2, "file":Ljava/io/File;
    :try_start_2d
    new-instance v6, Ljava/io/FileInputStream;

    invoke-direct {v6, v2}, Ljava/io/FileInputStream;-><init>(Ljava/io/File;)V

    .line 66
    .local v6, "instream":Ljava/io/FileInputStream;
    new-instance v5, Ljava/io/InputStreamReader;

    invoke-direct {v5, v6}, Ljava/io/InputStreamReader;-><init>(Ljava/io/InputStream;)V

    .line 67
    .local v5, "inputreader":Ljava/io/InputStreamReader;
    new-instance v9, Ljava/io/BufferedReader;

    invoke-direct {v9, v5}, Ljava/io/BufferedReader;-><init>(Ljava/io/Reader;)V

    .line 72
    .local v9, "reader":Ljava/io/BufferedReader;
    :cond_3c
    :goto_3c
    invoke-virtual {v9}, Ljava/io/BufferedReader;->readLine()Ljava/lang/String;

    move-result-object v8

    .local v8, "nextLine":Ljava/lang/String;
    if-eqz v8, :cond_75

    .line 73
    const-string v11, "PornAway"

    new-instance v12, Ljava/lang/StringBuilder;

    invoke-direct {v12}, Ljava/lang/StringBuilder;-><init>()V

    const-string v13, "nextLine: "

    invoke-virtual {v12, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v12

    invoke-virtual {v12, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v12

    invoke-virtual {v12}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v12

    invoke-static {v11, v12}, Lorg/pornaway/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 75
    invoke-static {v8}, Lorg/pornaway/util/RegexUtils;->getTcpdumpHostname(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 76
    .local v4, "hostname":Ljava/lang/String;
    if-eqz v4, :cond_3c

    .line 77
    invoke-virtual {v10, v4}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z
    :try_end_63
    .catch Ljava/io/FileNotFoundException; {:try_start_2d .. :try_end_63} :catch_64
    .catch Ljava/io/IOException; {:try_start_2d .. :try_end_63} :catch_7c

    goto :goto_3c

    .line 84
    .end local v4    # "hostname":Ljava/lang/String;
    .end local v5    # "inputreader":Ljava/io/InputStreamReader;
    .end local v6    # "instream":Ljava/io/FileInputStream;
    .end local v8    # "nextLine":Ljava/lang/String;
    .end local v9    # "reader":Ljava/io/BufferedReader;
    :catch_64
    move-exception v1

    .line 85
    .local v1, "e":Ljava/io/FileNotFoundException;
    :try_start_65
    const-string v11, "PornAway"

    const-string v12, "Tcpdump log is not existing!"

    invoke-static {v11, v12, v1}, Lorg/pornaway/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    :try_end_6c
    .catch Ljava/io/IOException; {:try_start_65 .. :try_end_6c} :catch_7c

    .line 91
    .end local v0    # "cachePath":Ljava/lang/String;
    .end local v1    # "e":Ljava/io/FileNotFoundException;
    .end local v2    # "file":Ljava/io/File;
    .end local v3    # "filePath":Ljava/lang/String;
    :goto_6c
    new-instance v7, Ljava/util/ArrayList;

    invoke-direct {v7, v10}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    .line 94
    .local v7, "list":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    invoke-static {v7}, Ljava/util/Collections;->sort(Ljava/util/List;)V

    .line 96
    return-object v7

    .line 81
    .end local v7    # "list":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    .restart local v0    # "cachePath":Ljava/lang/String;
    .restart local v2    # "file":Ljava/io/File;
    .restart local v3    # "filePath":Ljava/lang/String;
    .restart local v5    # "inputreader":Ljava/io/InputStreamReader;
    .restart local v6    # "instream":Ljava/io/FileInputStream;
    .restart local v8    # "nextLine":Ljava/lang/String;
    .restart local v9    # "reader":Ljava/io/BufferedReader;
    :cond_75
    :try_start_75
    invoke-virtual {v9}, Ljava/io/BufferedReader;->close()V

    .line 83
    invoke-virtual {v6}, Ljava/io/FileInputStream;->close()V
    :try_end_7b
    .catch Ljava/io/FileNotFoundException; {:try_start_75 .. :try_end_7b} :catch_64
    .catch Ljava/io/IOException; {:try_start_75 .. :try_end_7b} :catch_7c

    goto :goto_6c

    .line 87
    .end local v0    # "cachePath":Ljava/lang/String;
    .end local v2    # "file":Ljava/io/File;
    .end local v3    # "filePath":Ljava/lang/String;
    .end local v5    # "inputreader":Ljava/io/InputStreamReader;
    .end local v6    # "instream":Ljava/io/FileInputStream;
    .end local v8    # "nextLine":Ljava/lang/String;
    .end local v9    # "reader":Ljava/io/BufferedReader;
    :catch_7c
    move-exception v1

    .line 88
    .local v1, "e":Ljava/io/IOException;
    const-string v11, "PornAway"

    const-string v12, "Can not get cache dir"

    invoke-static {v11, v12, v1}, Lorg/pornaway/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_6c
.end method

.method protected onReset()V
    .registers 1

    .prologue
    .line 101
    invoke-super {p0}, Landroid/support/v4/content/AsyncTaskLoader;->onReset()V

    .line 104
    invoke-virtual {p0}, Lorg/pornaway/util/TcpdumpLogLoader;->onStopLoading()V

    .line 105
    return-void
.end method

.method protected onStartLoading()V
    .registers 1

    .prologue
    .line 109
    invoke-virtual {p0}, Lorg/pornaway/util/TcpdumpLogLoader;->forceLoad()V

    .line 110
    return-void
.end method

.method protected onStopLoading()V
    .registers 1

    .prologue
    .line 114
    invoke-virtual {p0}, Lorg/pornaway/util/TcpdumpLogLoader;->cancelLoad()Z

    .line 115
    return-void
.end method
