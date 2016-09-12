.class final Lorg/adaway/helper/ImportExportHelper$2;
.super Landroid/os/AsyncTask;
.source "ImportExportHelper.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lorg/adaway/helper/ImportExportHelper;->exportLists(Landroid/content/Context;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/os/AsyncTask",
        "<",
        "Ljava/lang/Void;",
        "Ljava/lang/Void;",
        "Ljava/lang/Void;",
        ">;"
    }
.end annotation


# instance fields
.field private mApplyProgressDialog:Landroid/app/ProgressDialog;

.field final synthetic val$context:Landroid/content/Context;


# direct methods
.method constructor <init>(Landroid/content/Context;)V
    .registers 2

    .prologue
    .line 160
    iput-object p1, p0, Lorg/adaway/helper/ImportExportHelper$2;->val$context:Landroid/content/Context;

    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    return-void
.end method


# virtual methods
.method protected bridge synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .registers 3

    .prologue
    .line 160
    check-cast p1, [Ljava/lang/Void;

    invoke-virtual {p0, p1}, Lorg/adaway/helper/ImportExportHelper$2;->doInBackground([Ljava/lang/Void;)Ljava/lang/Void;

    move-result-object v0

    return-object v0
.end method

.method protected varargs doInBackground([Ljava/lang/Void;)Ljava/lang/Void;
    .registers 17
    .param p1, "unused"    # [Ljava/lang/Void;

    .prologue
    .line 165
    iget-object v12, p0, Lorg/adaway/helper/ImportExportHelper$2;->val$context:Landroid/content/Context;

    invoke-static {v12}, Lorg/adaway/provider/ProviderHelper;->getEnabledWhitelistHashSet(Landroid/content/Context;)Lgnu/trove/set/hash/THashSet;

    move-result-object v10

    .line 166
    .local v10, "whitelist":Lgnu/trove/set/hash/THashSet;, "Lgnu/trove/set/hash/THashSet<Ljava/lang/String;>;"
    iget-object v12, p0, Lorg/adaway/helper/ImportExportHelper$2;->val$context:Landroid/content/Context;

    invoke-static {v12}, Lorg/adaway/provider/ProviderHelper;->getEnabledBlacklistHashSet(Landroid/content/Context;)Lgnu/trove/set/hash/THashSet;

    move-result-object v0

    .line 167
    .local v0, "blacklist":Lgnu/trove/set/hash/THashSet;, "Lgnu/trove/set/hash/THashSet<Ljava/lang/String;>;"
    iget-object v12, p0, Lorg/adaway/helper/ImportExportHelper$2;->val$context:Landroid/content/Context;

    invoke-static {v12}, Lorg/adaway/provider/ProviderHelper;->getEnabledRedirectionListHashMap(Landroid/content/Context;)Lgnu/trove/map/hash/THashMap;

    move-result-object v8

    .line 171
    .local v8, "redirectionList":Lgnu/trove/map/hash/THashMap;, "Lgnu/trove/map/hash/THashMap<Ljava/lang/String;Ljava/lang/String;>;"
    :try_start_12
    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v9

    .line 172
    .local v9, "sdcard":Ljava/io/File;
    invoke-virtual {v9}, Ljava/io/File;->canWrite()Z

    move-result v12

    if-eqz v12, :cond_8f

    .line 173
    new-instance v2, Ljava/io/File;

    const-string v12, "Pornaway-export"

    invoke-direct {v2, v9, v12}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    .line 174
    .local v2, "exportFile":Ljava/io/File;
    new-instance v11, Ljava/io/FileWriter;

    invoke-direct {v11, v2}, Ljava/io/FileWriter;-><init>(Ljava/io/File;)V

    .line 175
    .local v11, "writer":Ljava/io/FileWriter;
    new-instance v7, Ljava/io/BufferedWriter;

    invoke-direct {v7, v11}, Ljava/io/BufferedWriter;-><init>(Ljava/io/Writer;)V

    .line 177
    .local v7, "out":Ljava/io/BufferedWriter;
    new-instance v12, Ljava/lang/StringBuilder;

    invoke-direct {v12}, Ljava/lang/StringBuilder;-><init>()V

    const-string v13, "# This hosts file contains exported entries from AdAway."

    invoke-virtual {v12, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v12

    sget-object v13, Lorg/adaway/util/Constants;->LINE_SEPERATOR:Ljava/lang/String;

    invoke-virtual {v12, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v12

    invoke-virtual {v12}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v12

    invoke-virtual {v7, v12}, Ljava/io/BufferedWriter;->write(Ljava/lang/String;)V

    .line 180
    invoke-virtual {v0}, Lgnu/trove/set/hash/THashSet;->iterator()Lgnu/trove/iterator/hash/TObjectHashIterator;

    move-result-object v5

    .line 181
    .local v5, "itrBlacklist":Ljava/util/Iterator;, "Ljava/util/Iterator<Ljava/lang/String;>;"
    :goto_49
    invoke-interface {v5}, Ljava/util/Iterator;->hasNext()Z

    move-result v12

    if-eqz v12, :cond_91

    .line 182
    new-instance v12, Ljava/lang/StringBuilder;

    invoke-direct {v12}, Ljava/lang/StringBuilder;-><init>()V

    const-string v13, "127.0.0.1 "

    invoke-virtual {v12, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v13

    invoke-interface {v5}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v12

    check-cast v12, Ljava/lang/String;

    invoke-virtual {v13, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v12

    sget-object v13, Lorg/adaway/util/Constants;->LINE_SEPERATOR:Ljava/lang/String;

    invoke-virtual {v12, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v12

    invoke-virtual {v12}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v12

    invoke-virtual {v7, v12}, Ljava/io/BufferedWriter;->write(Ljava/lang/String;)V
    :try_end_71
    .catch Ljava/io/IOException; {:try_start_12 .. :try_end_71} :catch_72

    goto :goto_49

    .line 201
    .end local v2    # "exportFile":Ljava/io/File;
    .end local v5    # "itrBlacklist":Ljava/util/Iterator;, "Ljava/util/Iterator<Ljava/lang/String;>;"
    .end local v7    # "out":Ljava/io/BufferedWriter;
    .end local v9    # "sdcard":Ljava/io/File;
    .end local v11    # "writer":Ljava/io/FileWriter;
    :catch_72
    move-exception v1

    .line 202
    .local v1, "e":Ljava/io/IOException;
    const-string v12, "AdAway"

    new-instance v13, Ljava/lang/StringBuilder;

    invoke-direct {v13}, Ljava/lang/StringBuilder;-><init>()V

    const-string v14, "Could not write file "

    invoke-virtual {v13, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v13

    invoke-virtual {v1}, Ljava/io/IOException;->getMessage()Ljava/lang/String;

    move-result-object v14

    invoke-virtual {v13, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v13

    invoke-virtual {v13}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v13

    invoke-static {v12, v13}, Lorg/adaway/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 206
    .end local v1    # "e":Ljava/io/IOException;
    :cond_8f
    :goto_8f
    const/4 v12, 0x0

    return-object v12

    .line 187
    .restart local v2    # "exportFile":Ljava/io/File;
    .restart local v5    # "itrBlacklist":Ljava/util/Iterator;, "Ljava/util/Iterator<Ljava/lang/String;>;"
    .restart local v7    # "out":Ljava/io/BufferedWriter;
    .restart local v9    # "sdcard":Ljava/io/File;
    .restart local v11    # "writer":Ljava/io/FileWriter;
    :cond_91
    :try_start_91
    invoke-virtual {v10}, Lgnu/trove/set/hash/THashSet;->iterator()Lgnu/trove/iterator/hash/TObjectHashIterator;

    move-result-object v6

    .line 188
    .local v6, "itrWhitelist":Ljava/util/Iterator;, "Ljava/util/Iterator<Ljava/lang/String;>;"
    :goto_95
    invoke-interface {v6}, Ljava/util/Iterator;->hasNext()Z

    move-result v12

    if-eqz v12, :cond_be

    .line 189
    new-instance v12, Ljava/lang/StringBuilder;

    invoke-direct {v12}, Ljava/lang/StringBuilder;-><init>()V

    const-string v13, "white "

    invoke-virtual {v12, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v13

    invoke-interface {v6}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v12

    check-cast v12, Ljava/lang/String;

    invoke-virtual {v13, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v12

    sget-object v13, Lorg/adaway/util/Constants;->LINE_SEPERATOR:Ljava/lang/String;

    invoke-virtual {v12, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v12

    invoke-virtual {v12}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v12

    invoke-virtual {v7, v12}, Ljava/io/BufferedWriter;->write(Ljava/lang/String;)V

    goto :goto_95

    .line 194
    :cond_be
    invoke-virtual {v8}, Lgnu/trove/map/hash/THashMap;->entrySet()Ljava/util/Set;

    move-result-object v12

    invoke-interface {v12}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v3

    .local v3, "i$":Ljava/util/Iterator;
    :goto_c6
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v12

    if-eqz v12, :cond_ff

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/util/Map$Entry;

    .line 195
    .local v4, "item":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    new-instance v13, Ljava/lang/StringBuilder;

    invoke-direct {v13}, Ljava/lang/StringBuilder;-><init>()V

    invoke-interface {v4}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v12

    check-cast v12, Ljava/lang/String;

    invoke-virtual {v13, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v12

    const-string v13, " "

    invoke-virtual {v12, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v13

    invoke-interface {v4}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v12

    check-cast v12, Ljava/lang/String;

    invoke-virtual {v13, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v12

    sget-object v13, Lorg/adaway/util/Constants;->LINE_SEPERATOR:Ljava/lang/String;

    invoke-virtual {v12, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v12

    invoke-virtual {v12}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v12

    invoke-virtual {v7, v12}, Ljava/io/BufferedWriter;->write(Ljava/lang/String;)V

    goto :goto_c6

    .line 199
    .end local v4    # "item":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    :cond_ff
    invoke-virtual {v7}, Ljava/io/BufferedWriter;->close()V
    :try_end_102
    .catch Ljava/io/IOException; {:try_start_91 .. :try_end_102} :catch_72

    goto :goto_8f
.end method

.method protected bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .registers 2

    .prologue
    .line 160
    check-cast p1, Ljava/lang/Void;

    invoke-virtual {p0, p1}, Lorg/adaway/helper/ImportExportHelper$2;->onPostExecute(Ljava/lang/Void;)V

    return-void
.end method

.method protected onPostExecute(Ljava/lang/Void;)V
    .registers 6
    .param p1, "unused"    # Ljava/lang/Void;

    .prologue
    .line 221
    invoke-super {p0, p1}, Landroid/os/AsyncTask;->onPostExecute(Ljava/lang/Object;)V

    .line 223
    iget-object v1, p0, Lorg/adaway/helper/ImportExportHelper$2;->mApplyProgressDialog:Landroid/app/ProgressDialog;

    invoke-virtual {v1}, Landroid/app/ProgressDialog;->dismiss()V

    .line 224
    iget-object v1, p0, Lorg/adaway/helper/ImportExportHelper$2;->val$context:Landroid/content/Context;

    iget-object v2, p0, Lorg/adaway/helper/ImportExportHelper$2;->val$context:Landroid/content/Context;

    const v3, 0x7f080044

    invoke-virtual {v2, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    const/4 v3, 0x1

    invoke-static {v1, v2, v3}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v0

    .line 226
    .local v0, "toast":Landroid/widget/Toast;
    invoke-virtual {v0}, Landroid/widget/Toast;->show()V

    .line 227
    return-void
.end method

.method protected onPreExecute()V
    .registers 5

    .prologue
    const/4 v3, 0x0

    .line 211
    invoke-super {p0}, Landroid/os/AsyncTask;->onPreExecute()V

    .line 212
    new-instance v0, Landroid/app/ProgressDialog;

    iget-object v1, p0, Lorg/adaway/helper/ImportExportHelper$2;->val$context:Landroid/content/Context;

    invoke-direct {v0, v1}, Landroid/app/ProgressDialog;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lorg/adaway/helper/ImportExportHelper$2;->mApplyProgressDialog:Landroid/app/ProgressDialog;

    .line 213
    iget-object v0, p0, Lorg/adaway/helper/ImportExportHelper$2;->mApplyProgressDialog:Landroid/app/ProgressDialog;

    iget-object v1, p0, Lorg/adaway/helper/ImportExportHelper$2;->val$context:Landroid/content/Context;

    const v2, 0x7f080043

    invoke-virtual {v1, v2}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/app/ProgressDialog;->setMessage(Ljava/lang/CharSequence;)V

    .line 214
    iget-object v0, p0, Lorg/adaway/helper/ImportExportHelper$2;->mApplyProgressDialog:Landroid/app/ProgressDialog;

    invoke-virtual {v0, v3}, Landroid/app/ProgressDialog;->setProgressStyle(I)V

    .line 215
    iget-object v0, p0, Lorg/adaway/helper/ImportExportHelper$2;->mApplyProgressDialog:Landroid/app/ProgressDialog;

    invoke-virtual {v0, v3}, Landroid/app/ProgressDialog;->setCancelable(Z)V

    .line 216
    iget-object v0, p0, Lorg/adaway/helper/ImportExportHelper$2;->mApplyProgressDialog:Landroid/app/ProgressDialog;

    invoke-virtual {v0}, Landroid/app/ProgressDialog;->show()V

    .line 217
    return-void
.end method
