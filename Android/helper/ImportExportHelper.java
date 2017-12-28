.class public Lorg/pornaway/helper/ImportExportHelper;
.super Ljava/lang/Object;
.source "ImportExportHelper.java"


# static fields
.field static final REQUEST_CODE_IMPORT:I = 0x2a


# direct methods
.method public constructor <init>()V
    .registers 1

    .prologue
    .line 55
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static exportLists(Landroid/content/Context;)V
    .registers 3
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 160
    new-instance v0, Lorg/pornaway/helper/ImportExportHelper$2;

    invoke-direct {v0, p0}, Lorg/pornaway/helper/ImportExportHelper$2;-><init>(Landroid/content/Context;)V

    .line 230
    .local v0, "exportListsTask":Landroid/os/AsyncTask;, "Landroid/os/AsyncTask<Ljava/lang/Void;Ljava/lang/Void;Ljava/lang/Void;>;"
    const/4 v1, 0x0

    new-array v1, v1, [Ljava/lang/Void;

    invoke-virtual {v0, v1}, Landroid/os/AsyncTask;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 231
    return-void
.end method

.method public static onActivityResultHandleImport(Landroid/content/Context;IILandroid/content/Intent;)V
    .registers 9
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "requestCode"    # I
    .param p2, "resultCode"    # I
    .param p3, "data"    # Landroid/content/Intent;

    .prologue
    .line 93
    const/16 v2, 0x2a

    if-ne p1, v2, :cond_3a

    const/4 v2, -0x1

    if-ne p2, v2, :cond_3a

    if-eqz p3, :cond_3a

    .line 94
    invoke-virtual {p3}, Landroid/content/Intent;->getData()Landroid/net/Uri;

    move-result-object v2

    if-eqz v2, :cond_3a

    .line 96
    invoke-virtual {p3}, Landroid/content/Intent;->getData()Landroid/net/Uri;

    move-result-object v1

    .line 97
    .local v1, "result":Landroid/net/Uri;
    const-string v2, "PornAway"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "File manager Uri: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v1}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Lorg/pornaway/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 100
    new-instance v0, Lorg/pornaway/helper/ImportExportHelper$1;

    invoke-direct {v0, p0, v1}, Lorg/pornaway/helper/ImportExportHelper$1;-><init>(Landroid/content/Context;Landroid/net/Uri;)V

    .line 149
    .local v0, "importListsTask":Landroid/os/AsyncTask;, "Landroid/os/AsyncTask<Ljava/lang/Void;Ljava/lang/Void;Ljava/lang/Void;>;"
    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Void;

    invoke-virtual {v0, v2}, Landroid/os/AsyncTask;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 151
    .end local v0    # "importListsTask":Landroid/os/AsyncTask;, "Landroid/os/AsyncTask<Ljava/lang/Void;Ljava/lang/Void;Ljava/lang/Void;>;"
    .end local v1    # "result":Landroid/net/Uri;
    :cond_3a
    return-void
.end method

.method public static openFileStream(Landroid/support/v4/app/FragmentActivity;)V
    .registers 8
    .param p0, "activity"    # Landroid/support/v4/app/FragmentActivity;

    .prologue
    .line 66
    new-instance v1, Landroid/content/Intent;

    const-string v3, "android.intent.action.GET_CONTENT"

    invoke-direct {v1, v3}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 67
    .local v1, "intent":Landroid/content/Intent;
    const-string v3, "text/plain"

    invoke-virtual {v1, v3}, Landroid/content/Intent;->setType(Ljava/lang/String;)Landroid/content/Intent;

    .line 68
    const-string v3, "android.intent.category.OPENABLE"

    invoke-virtual {v1, v3}, Landroid/content/Intent;->addCategory(Ljava/lang/String;)Landroid/content/Intent;

    .line 71
    const/16 v3, 0x2a

    :try_start_13
    invoke-virtual {p0, v1, v3}, Landroid/support/v4/app/FragmentActivity;->startActivityForResult(Landroid/content/Intent;I)V
    :try_end_16
    .catch Landroid/content/ActivityNotFoundException; {:try_start_13 .. :try_end_16} :catch_17

    .line 79
    :goto_16
    return-void

    .line 72
    :catch_17
    move-exception v0

    .line 73
    .local v0, "e":Landroid/content/ActivityNotFoundException;
    const v3, 0x7f08005b

    const v4, 0x7f0800a9

    const-string v5, "market://details?id=org.openintents.filemanager"

    const-string v6, "OI File Manager"

    .line 74
    invoke-static {v3, v4, v5, v6}, Lorg/pornaway/ui/dialog/ActivityNotFoundDialogFragment;->newInstance(IILjava/lang/String;Ljava/lang/String;)Lorg/pornaway/ui/dialog/ActivityNotFoundDialogFragment;

    move-result-object v2

    .line 77
    .local v2, "notFoundDialog":Lorg/pornaway/ui/dialog/ActivityNotFoundDialogFragment;
    invoke-virtual {p0}, Landroid/support/v4/app/FragmentActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v3

    const-string v4, "notFoundDialog"

    invoke-virtual {v2, v3, v4}, Lorg/pornaway/ui/dialog/ActivityNotFoundDialogFragment;->show(Landroid/support/v4/app/FragmentManager;Ljava/lang/String;)V

    goto :goto_16
.end method
