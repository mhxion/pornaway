.class public Lorg/pornaway/util/Utils;
.super Ljava/lang/Object;
.source "Utils.java"


# direct methods
.method public constructor <init>()V
    .registers 1

    .prologue
    .line 53
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static isAndroidOnline(Landroid/content/Context;)Z
    .registers 4
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 169
    const-string v2, "connectivity"

    .line 170
    invoke-virtual {p0, v2}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/net/ConnectivityManager;

    .line 171
    .local v0, "cm":Landroid/net/ConnectivityManager;
    invoke-virtual {v0}, Landroid/net/ConnectivityManager;->getActiveNetworkInfo()Landroid/net/NetworkInfo;

    move-result-object v1

    .line 172
    .local v1, "netInfo":Landroid/net/NetworkInfo;
    if-eqz v1, :cond_16

    invoke-virtual {v1}, Landroid/net/NetworkInfo;->isConnectedOrConnecting()Z

    move-result v2

    if-eqz v2, :cond_16

    .line 173
    const/4 v2, 0x1

    .line 175
    :goto_15
    return v2

    :cond_16
    const/4 v2, 0x0

    goto :goto_15
.end method

.method public static isAndroidRooted(Landroid/app/Activity;)Z
    .registers 8
    .param p0, "activity"    # Landroid/app/Activity;

    .prologue
    .line 63
    const/4 v4, 0x0

    .line 69
    .local v4, "rootAccess":Z
    invoke-static {}, Lorg/sufficientlysecure/rootcommands/RootCommands;->rootAccessGiven()Z

    move-result v5

    if-eqz v5, :cond_9

    .line 70
    const/4 v4, 0x1

    .line 96
    :goto_8
    return v4

    .line 72
    :cond_9
    new-instance v1, Landroid/app/AlertDialog$Builder;

    invoke-direct {v1, p0}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 73
    .local v1, "builder":Landroid/app/AlertDialog$Builder;
    const/4 v5, 0x0

    invoke-virtual {v1, v5}, Landroid/app/AlertDialog$Builder;->setCancelable(Z)Landroid/app/AlertDialog$Builder;

    .line 74
    const v5, 0x1080027

    invoke-virtual {v1, v5}, Landroid/app/AlertDialog$Builder;->setIcon(I)Landroid/app/AlertDialog$Builder;

    .line 75
    const v5, 0x7f080062

    invoke-virtual {p0, v5}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v1, v5}, Landroid/app/AlertDialog$Builder;->setTitle(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    .line 78
    invoke-static {p0}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v3

    .line 79
    .local v3, "factory":Landroid/view/LayoutInflater;
    const v5, 0x7f040026

    const/4 v6, 0x0

    invoke-virtual {v3, v5, v6}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v2

    .line 80
    .local v2, "dialogView":Landroid/view/View;
    invoke-virtual {v1, v2}, Landroid/app/AlertDialog$Builder;->setView(Landroid/view/View;)Landroid/app/AlertDialog$Builder;

    .line 82
    invoke-virtual {p0}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v5

    const v6, 0x7f08001b

    invoke-virtual {v5, v6}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v5

    new-instance v6, Lorg/pornaway/util/Utils$1;

    invoke-direct {v6, p0}, Lorg/pornaway/util/Utils$1;-><init>(Landroid/app/Activity;)V

    invoke-virtual {v1, v5, v6}, Landroid/app/AlertDialog$Builder;->setNeutralButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    .line 91
    invoke-virtual {v1}, Landroid/app/AlertDialog$Builder;->create()Landroid/app/AlertDialog;

    move-result-object v0

    .line 92
    .local v0, "alert":Landroid/app/AlertDialog;
    invoke-virtual {v0}, Landroid/app/AlertDialog;->show()V

    goto :goto_8
.end method

.method public static isInForeground(Landroid/content/Context;)Z
    .registers 6
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 222
    new-instance v2, Lorg/pornaway/util/Utils$4;

    invoke-direct {v2}, Lorg/pornaway/util/Utils$4;-><init>()V

    .line 248
    .local v2, "foregroundCheckTask":Landroid/os/AsyncTask;, "Landroid/os/AsyncTask<Landroid/content/Context;Ljava/lang/Void;Ljava/lang/Boolean;>;"
    const/4 v1, 0x0

    .line 250
    .local v1, "foreground":Z
    const/4 v3, 0x1

    :try_start_7
    new-array v3, v3, [Landroid/content/Context;

    const/4 v4, 0x0

    aput-object p0, v3, v4

    invoke-virtual {v2, v3}, Landroid/os/AsyncTask;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    move-result-object v3

    invoke-virtual {v3}, Landroid/os/AsyncTask;->get()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/Boolean;

    invoke-virtual {v3}, Ljava/lang/Boolean;->booleanValue()Z
    :try_end_19
    .catch Ljava/lang/InterruptedException; {:try_start_7 .. :try_end_19} :catch_1b
    .catch Ljava/util/concurrent/ExecutionException; {:try_start_7 .. :try_end_19} :catch_24

    move-result v1

    .line 257
    :goto_1a
    return v1

    .line 251
    :catch_1b
    move-exception v0

    .line 252
    .local v0, "e":Ljava/lang/InterruptedException;
    const-string v3, "PornAway"

    const-string v4, "IsInForeground InterruptedException"

    invoke-static {v3, v4, v0}, Lorg/pornaway/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_1a

    .line 253
    .end local v0    # "e":Ljava/lang/InterruptedException;
    :catch_24
    move-exception v0

    .line 254
    .local v0, "e":Ljava/util/concurrent/ExecutionException;
    const-string v3, "PornAway"

    const-string v4, "IsInForeground ExecutionException"

    invoke-static {v3, v4, v0}, Lorg/pornaway/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_1a
.end method

.method public static isInstalledOnSdCard(Landroid/content/Context;)Z
    .registers 10
    .param p0, "context"    # Landroid/content/Context;
    .annotation build Landroid/annotation/SuppressLint;
        value = {
            "SdCardPath"
        }
    .end annotation

    .prologue
    const/high16 v8, 0x40000

    const/4 v4, 0x1

    const/4 v5, 0x0

    .line 188
    sget v6, Landroid/os/Build$VERSION;->SDK_INT:I

    const/4 v7, 0x7

    if-le v6, v7, :cond_21

    .line 189
    invoke-virtual {p0}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v3

    .line 191
    .local v3, "pm":Landroid/content/pm/PackageManager;
    :try_start_d
    invoke-virtual {p0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v6

    const/4 v7, 0x0

    invoke-virtual {v3, v6, v7}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v2

    .line 192
    .local v2, "pi":Landroid/content/pm/PackageInfo;
    iget-object v0, v2, Landroid/content/pm/PackageInfo;->applicationInfo:Landroid/content/pm/ApplicationInfo;

    .line 193
    .local v0, "ai":Landroid/content/pm/ApplicationInfo;
    iget v6, v0, Landroid/content/pm/ApplicationInfo;->flags:I
    :try_end_1a
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_d .. :try_end_1a} :catch_20

    and-int/2addr v6, v8

    if-ne v6, v8, :cond_1e

    .line 211
    .end local v0    # "ai":Landroid/content/pm/ApplicationInfo;
    .end local v2    # "pi":Landroid/content/pm/PackageInfo;
    .end local v3    # "pm":Landroid/content/pm/PackageManager;
    :cond_1d
    :goto_1d
    return v4

    .restart local v0    # "ai":Landroid/content/pm/ApplicationInfo;
    .restart local v2    # "pi":Landroid/content/pm/PackageInfo;
    .restart local v3    # "pm":Landroid/content/pm/PackageManager;
    :cond_1e
    move v4, v5

    .line 193
    goto :goto_1d

    .line 194
    .end local v0    # "ai":Landroid/content/pm/ApplicationInfo;
    .end local v2    # "pi":Landroid/content/pm/PackageInfo;
    :catch_20
    move-exception v6

    .line 201
    .end local v3    # "pm":Landroid/content/pm/PackageManager;
    :cond_21
    :try_start_21
    invoke-virtual {p0}, Landroid/content/Context;->getFilesDir()Ljava/io/File;

    move-result-object v6

    invoke-virtual {v6}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v1

    .line 202
    .local v1, "filesDir":Ljava/lang/String;
    const-string v6, "/data/"

    invoke-virtual {v1, v6}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_33

    move v4, v5

    .line 203
    goto :goto_1d

    .line 204
    :cond_33
    const-string v6, "/mnt/"

    invoke-virtual {v1, v6}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v6

    if-nez v6, :cond_1d

    const-string v6, "/sdcard/"

    invoke-virtual {v1, v6}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z
    :try_end_40
    .catch Ljava/lang/Throwable; {:try_start_21 .. :try_end_40} :catch_45

    move-result v6

    if-nez v6, :cond_1d

    .end local v1    # "filesDir":Ljava/lang/String;
    :goto_43
    move v4, v5

    .line 211
    goto :goto_1d

    .line 207
    :catch_45
    move-exception v4

    goto :goto_43
.end method

.method public static rebootQuestion(Landroid/content/Context;II)V
    .registers 10
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "titleR"    # I
    .param p2, "messageR"    # I

    .prologue
    .line 106
    new-instance v0, Landroid/app/AlertDialog$Builder;

    invoke-direct {v0, p0}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 107
    .local v0, "builder":Landroid/app/AlertDialog$Builder;
    invoke-virtual {v0, p1}, Landroid/app/AlertDialog$Builder;->setTitle(I)Landroid/app/AlertDialog$Builder;

    .line 108
    const v5, 0x108009b

    invoke-virtual {v0, v5}, Landroid/app/AlertDialog$Builder;->setIcon(I)Landroid/app/AlertDialog$Builder;

    .line 111
    invoke-static {p0}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v2

    .line 112
    .local v2, "factory":Landroid/view/LayoutInflater;
    const v5, 0x7f040027

    const/4 v6, 0x0

    invoke-virtual {v2, v5, v6}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v1

    .line 115
    .local v1, "dialogView":Landroid/view/View;
    const v5, 0x7f0e005a

    invoke-virtual {v1, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/TextView;

    .line 116
    .local v4, "text":Landroid/widget/TextView;
    invoke-virtual {p0, p2}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 118
    invoke-virtual {v0, v1}, Landroid/app/AlertDialog$Builder;->setView(Landroid/view/View;)Landroid/app/AlertDialog$Builder;

    .line 120
    const v5, 0x7f080029

    invoke-virtual {p0, v5}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v5

    new-instance v6, Lorg/pornaway/util/Utils$2;

    invoke-direct {v6, v1, p0}, Lorg/pornaway/util/Utils$2;-><init>(Landroid/view/View;Landroid/content/Context;)V

    invoke-virtual {v0, v5, v6}, Landroid/app/AlertDialog$Builder;->setPositiveButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    .line 142
    const v5, 0x7f08001d

    invoke-virtual {p0, v5}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v5

    new-instance v6, Lorg/pornaway/util/Utils$3;

    invoke-direct {v6, v1, p0}, Lorg/pornaway/util/Utils$3;-><init>(Landroid/view/View;Landroid/content/Context;)V

    invoke-virtual {v0, v5, v6}, Landroid/app/AlertDialog$Builder;->setNegativeButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    .line 157
    invoke-virtual {v0}, Landroid/app/AlertDialog$Builder;->create()Landroid/app/AlertDialog;

    move-result-object v3

    .line 159
    .local v3, "question":Landroid/app/AlertDialog;
    invoke-virtual {v3}, Landroid/app/AlertDialog;->show()V

    .line 160
    return-void
.end method
