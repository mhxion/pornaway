.class public Lorg/pornaway/util/ScanAdwareLoader;
.super Landroid/support/v4/content/AsyncTaskLoader;
.source "ScanAdwareLoader.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/support/v4/content/AsyncTaskLoader",
        "<",
        "Ljava/util/List",
        "<",
        "Ljava/util/Map",
        "<",
        "Ljava/lang/String;",
        "Ljava/lang/String;",
        ">;>;>;"
    }
.end annotation


# static fields
.field public static final AD_PACKAGE_PREFIXES:[Ljava/lang/String;


# instance fields
.field private volatile canceled:Z

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
.method static constructor <clinit>()V
    .registers 3

    .prologue
    .line 42
    const/16 v0, 0xc

    new-array v0, v0, [Ljava/lang/String;

    const/4 v1, 0x0

    const-string v2, "com.airpush."

    aput-object v2, v0, v1

    const/4 v1, 0x1

    const-string v2, "com.Leadbolt."

    aput-object v2, v0, v1

    const/4 v1, 0x2

    const-string v2, "com.appenda."

    aput-object v2, v0, v1

    const/4 v1, 0x3

    const-string v2, "com.iac.notification."

    aput-object v2, v0, v1

    const/4 v1, 0x4

    const-string v2, "com.appbucks.sdk."

    aput-object v2, v0, v1

    const/4 v1, 0x5

    const-string v2, "com.tapjoy."

    aput-object v2, v0, v1

    const/4 v1, 0x6

    const-string v2, "com.sellaring."

    aput-object v2, v0, v1

    const/4 v1, 0x7

    const-string v2, "com.inmobi."

    aput-object v2, v0, v1

    const/16 v1, 0x8

    const-string v2, "com.senddroid."

    aput-object v2, v0, v1

    const/16 v1, 0x9

    const-string v2, "cn.kuguo."

    aput-object v2, v0, v1

    const/16 v1, 0xa

    const-string v2, "com.applovin."

    aput-object v2, v0, v1

    const/16 v1, 0xb

    const-string v2, "com.adnotify."

    aput-object v2, v0, v1

    sput-object v0, Lorg/pornaway/util/ScanAdwareLoader;->AD_PACKAGE_PREFIXES:[Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .registers 3
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 52
    invoke-direct {p0, p1}, Landroid/support/v4/content/AsyncTaskLoader;-><init>(Landroid/content/Context;)V

    .line 49
    const/4 v0, 0x0

    iput-boolean v0, p0, Lorg/pornaway/util/ScanAdwareLoader;->canceled:Z

    .line 54
    iput-object p1, p0, Lorg/pornaway/util/ScanAdwareLoader;->context:Landroid/content/Context;

    .line 55
    return-void
.end method

.method private getAdPackages()Ljava/util/List;
    .registers 22
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Landroid/content/pm/PackageInfo;",
            ">;"
        }
    .end annotation

    .prologue
    .line 104
    new-instance v3, Ljava/util/HashSet;

    invoke-direct {v3}, Ljava/util/HashSet;-><init>()V

    .line 106
    .local v3, "adPackages":Ljava/util/Set;, "Ljava/util/Set<Landroid/content/pm/PackageInfo;>;"
    move-object/from16 v0, p0

    iget-object v11, v0, Lorg/pornaway/util/ScanAdwareLoader;->context:Landroid/content/Context;

    invoke-virtual {v11}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v8

    .line 108
    .local v8, "pm":Landroid/content/pm/PackageManager;
    const/4 v11, 0x0

    invoke-virtual {v8, v11}, Landroid/content/pm/PackageManager;->getInstalledApplications(I)Ljava/util/List;

    move-result-object v5

    .line 110
    .local v5, "appInfos":Ljava/util/List;, "Ljava/util/List<Landroid/content/pm/ApplicationInfo;>;"
    invoke-interface {v5}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v13

    :cond_16
    :goto_16
    invoke-interface {v13}, Ljava/util/Iterator;->hasNext()Z

    move-result v11

    if-eqz v11, :cond_2b

    invoke-interface {v13}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Landroid/content/pm/ApplicationInfo;

    .line 111
    .local v4, "appInfo":Landroid/content/pm/ApplicationInfo;
    move-object/from16 v0, p0

    iget-boolean v11, v0, Lorg/pornaway/util/ScanAdwareLoader;->canceled:Z

    if-eqz v11, :cond_31

    .line 112
    invoke-interface {v3}, Ljava/util/Set;->clear()V

    .line 169
    .end local v4    # "appInfo":Landroid/content/pm/ApplicationInfo;
    :cond_2b
    new-instance v11, Ljava/util/ArrayList;

    invoke-direct {v11, v3}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    return-object v11

    .line 116
    .restart local v4    # "appInfo":Landroid/content/pm/ApplicationInfo;
    :cond_31
    :try_start_31
    iget-object v11, v4, Landroid/content/pm/ApplicationInfo;->packageName:Ljava/lang/String;

    const/4 v12, 0x7

    invoke-virtual {v8, v11, v12}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v7

    .line 121
    .local v7, "pkgInfo":Landroid/content/pm/PackageInfo;
    const-string v11, "PornAway"

    new-instance v12, Ljava/lang/StringBuilder;

    invoke-direct {v12}, Ljava/lang/StringBuilder;-><init>()V

    const-string v14, "Scanning package "

    invoke-virtual {v12, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v12

    iget-object v14, v7, Landroid/content/pm/PackageInfo;->packageName:Ljava/lang/String;

    invoke-virtual {v12, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v12

    invoke-virtual {v12}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v12

    invoke-static {v11, v12}, Lorg/pornaway/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)V

    .line 123
    iget-object v11, v7, Landroid/content/pm/PackageInfo;->activities:[Landroid/content/pm/ActivityInfo;

    if-eqz v11, :cond_d7

    .line 124
    iget-object v14, v7, Landroid/content/pm/PackageInfo;->activities:[Landroid/content/pm/ActivityInfo;

    array-length v15, v14

    const/4 v11, 0x0

    move v12, v11

    :goto_5b
    if-ge v12, v15, :cond_d7

    aget-object v1, v14, v12

    .line 125
    .local v1, "activity":Landroid/content/pm/ActivityInfo;
    const-string v11, "PornAway"

    new-instance v16, Ljava/lang/StringBuilder;

    invoke-direct/range {v16 .. v16}, Ljava/lang/StringBuilder;-><init>()V

    const-string v17, "[ACTIVITY] "

    invoke-virtual/range {v16 .. v17}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v16

    iget-object v0, v1, Landroid/content/pm/ActivityInfo;->name:Ljava/lang/String;

    move-object/from16 v17, v0

    invoke-virtual/range {v16 .. v17}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v16

    move-object/from16 v0, v16

    invoke-static {v11, v0}, Lorg/pornaway/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)V

    .line 126
    sget-object v16, Lorg/pornaway/util/ScanAdwareLoader;->AD_PACKAGE_PREFIXES:[Ljava/lang/String;

    move-object/from16 v0, v16

    array-length v0, v0

    move/from16 v17, v0

    const/4 v11, 0x0

    :goto_85
    move/from16 v0, v17

    if-ge v11, v0, :cond_d3

    aget-object v2, v16, v11

    .line 127
    .local v2, "adPackagePrefix":Ljava/lang/String;
    iget-object v0, v1, Landroid/content/pm/ActivityInfo;->name:Ljava/lang/String;

    move-object/from16 v18, v0

    move-object/from16 v0, v18

    invoke-virtual {v0, v2}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v18

    if-eqz v18, :cond_d0

    .line 128
    const-string v18, "PornAway"

    new-instance v19, Ljava/lang/StringBuilder;

    invoke-direct/range {v19 .. v19}, Ljava/lang/StringBuilder;-><init>()V

    const-string v20, "Detected ad framework prefix "

    invoke-virtual/range {v19 .. v20}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v19

    move-object/from16 v0, v19

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v19

    const-string v20, " in package "

    invoke-virtual/range {v19 .. v20}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v19

    iget-object v0, v7, Landroid/content/pm/PackageInfo;->packageName:Ljava/lang/String;

    move-object/from16 v20, v0

    invoke-virtual/range {v19 .. v20}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v19

    const-string v20, " as activity "

    invoke-virtual/range {v19 .. v20}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v19

    iget-object v0, v1, Landroid/content/pm/ActivityInfo;->name:Ljava/lang/String;

    move-object/from16 v20, v0

    invoke-virtual/range {v19 .. v20}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v19

    invoke-virtual/range {v19 .. v19}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v19

    invoke-static/range {v18 .. v19}, Lorg/pornaway/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 131
    invoke-interface {v3, v7}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 126
    :cond_d0
    add-int/lit8 v11, v11, 0x1

    goto :goto_85

    .line 124
    .end local v2    # "adPackagePrefix":Ljava/lang/String;
    :cond_d3
    add-int/lit8 v11, v12, 0x1

    move v12, v11

    goto :goto_5b

    .line 136
    .end local v1    # "activity":Landroid/content/pm/ActivityInfo;
    :cond_d7
    iget-object v11, v7, Landroid/content/pm/PackageInfo;->receivers:[Landroid/content/pm/ActivityInfo;

    if-eqz v11, :cond_15e

    .line 137
    iget-object v14, v7, Landroid/content/pm/PackageInfo;->receivers:[Landroid/content/pm/ActivityInfo;

    array-length v15, v14

    const/4 v11, 0x0

    move v12, v11

    :goto_e0
    if-ge v12, v15, :cond_15e

    aget-object v9, v14, v12

    .line 138
    .local v9, "receiver":Landroid/content/pm/ActivityInfo;
    const-string v11, "PornAway"

    new-instance v16, Ljava/lang/StringBuilder;

    invoke-direct/range {v16 .. v16}, Ljava/lang/StringBuilder;-><init>()V

    const-string v17, "[RECEIVER] "

    invoke-virtual/range {v16 .. v17}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v16

    iget-object v0, v9, Landroid/content/pm/ActivityInfo;->name:Ljava/lang/String;

    move-object/from16 v17, v0

    invoke-virtual/range {v16 .. v17}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v16

    move-object/from16 v0, v16

    invoke-static {v11, v0}, Lorg/pornaway/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)V

    .line 139
    sget-object v16, Lorg/pornaway/util/ScanAdwareLoader;->AD_PACKAGE_PREFIXES:[Ljava/lang/String;

    move-object/from16 v0, v16

    array-length v0, v0

    move/from16 v17, v0

    const/4 v11, 0x0

    :goto_10a
    move/from16 v0, v17

    if-ge v11, v0, :cond_157

    aget-object v2, v16, v11

    .line 140
    .restart local v2    # "adPackagePrefix":Ljava/lang/String;
    iget-object v0, v9, Landroid/content/pm/ActivityInfo;->name:Ljava/lang/String;

    move-object/from16 v18, v0

    move-object/from16 v0, v18

    invoke-virtual {v0, v2}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v18

    if-eqz v18, :cond_15b

    .line 141
    const-string v11, "PornAway"

    new-instance v16, Ljava/lang/StringBuilder;

    invoke-direct/range {v16 .. v16}, Ljava/lang/StringBuilder;-><init>()V

    const-string v17, "Detected ad framework prefix "

    invoke-virtual/range {v16 .. v17}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v16

    move-object/from16 v0, v16

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v16

    const-string v17, " in package "

    invoke-virtual/range {v16 .. v17}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v16

    iget-object v0, v7, Landroid/content/pm/PackageInfo;->packageName:Ljava/lang/String;

    move-object/from16 v17, v0

    invoke-virtual/range {v16 .. v17}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v16

    const-string v17, " as receiver "

    invoke-virtual/range {v16 .. v17}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v16

    iget-object v0, v9, Landroid/content/pm/ActivityInfo;->name:Ljava/lang/String;

    move-object/from16 v17, v0

    invoke-virtual/range {v16 .. v17}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v16

    move-object/from16 v0, v16

    invoke-static {v11, v0}, Lorg/pornaway/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 144
    invoke-interface {v3, v7}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 137
    .end local v2    # "adPackagePrefix":Ljava/lang/String;
    :cond_157
    add-int/lit8 v11, v12, 0x1

    move v12, v11

    goto :goto_e0

    .line 139
    .restart local v2    # "adPackagePrefix":Ljava/lang/String;
    :cond_15b
    add-int/lit8 v11, v11, 0x1

    goto :goto_10a

    .line 150
    .end local v2    # "adPackagePrefix":Ljava/lang/String;
    .end local v9    # "receiver":Landroid/content/pm/ActivityInfo;
    :cond_15e
    iget-object v11, v7, Landroid/content/pm/PackageInfo;->services:[Landroid/content/pm/ServiceInfo;

    if-eqz v11, :cond_16

    .line 151
    iget-object v14, v7, Landroid/content/pm/PackageInfo;->services:[Landroid/content/pm/ServiceInfo;

    array-length v15, v14

    const/4 v11, 0x0

    move v12, v11

    :goto_167
    if-ge v12, v15, :cond_16

    aget-object v10, v14, v12

    .line 152
    .local v10, "service":Landroid/content/pm/ServiceInfo;
    const-string v11, "PornAway"

    new-instance v16, Ljava/lang/StringBuilder;

    invoke-direct/range {v16 .. v16}, Ljava/lang/StringBuilder;-><init>()V

    const-string v17, "[SERVICE] "

    invoke-virtual/range {v16 .. v17}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v16

    iget-object v0, v10, Landroid/content/pm/ServiceInfo;->name:Ljava/lang/String;

    move-object/from16 v17, v0

    invoke-virtual/range {v16 .. v17}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v16

    move-object/from16 v0, v16

    invoke-static {v11, v0}, Lorg/pornaway/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)V

    .line 153
    sget-object v16, Lorg/pornaway/util/ScanAdwareLoader;->AD_PACKAGE_PREFIXES:[Ljava/lang/String;

    move-object/from16 v0, v16

    array-length v0, v0

    move/from16 v17, v0

    const/4 v11, 0x0

    :goto_191
    move/from16 v0, v17

    if-ge v11, v0, :cond_1de

    aget-object v2, v16, v11

    .line 154
    .restart local v2    # "adPackagePrefix":Ljava/lang/String;
    iget-object v0, v10, Landroid/content/pm/ServiceInfo;->name:Ljava/lang/String;

    move-object/from16 v18, v0

    move-object/from16 v0, v18

    invoke-virtual {v0, v2}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v18

    if-eqz v18, :cond_1e2

    .line 155
    const-string v11, "PornAway"

    new-instance v16, Ljava/lang/StringBuilder;

    invoke-direct/range {v16 .. v16}, Ljava/lang/StringBuilder;-><init>()V

    const-string v17, "Detected ad framework prefix "

    invoke-virtual/range {v16 .. v17}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v16

    move-object/from16 v0, v16

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v16

    const-string v17, " in package "

    invoke-virtual/range {v16 .. v17}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v16

    iget-object v0, v7, Landroid/content/pm/PackageInfo;->packageName:Ljava/lang/String;

    move-object/from16 v17, v0

    invoke-virtual/range {v16 .. v17}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v16

    const-string v17, " as service "

    invoke-virtual/range {v16 .. v17}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v16

    iget-object v0, v10, Landroid/content/pm/ServiceInfo;->name:Ljava/lang/String;

    move-object/from16 v17, v0

    invoke-virtual/range {v16 .. v17}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v16

    move-object/from16 v0, v16

    invoke-static {v11, v0}, Lorg/pornaway/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 158
    invoke-interface {v3, v7}, Ljava/util/Set;->add(Ljava/lang/Object;)Z
    :try_end_1de
    .catch Ljava/lang/Exception; {:try_start_31 .. :try_end_1de} :catch_1e5

    .line 151
    .end local v2    # "adPackagePrefix":Ljava/lang/String;
    :cond_1de
    add-int/lit8 v11, v12, 0x1

    move v12, v11

    goto :goto_167

    .line 153
    .restart local v2    # "adPackagePrefix":Ljava/lang/String;
    :cond_1e2
    add-int/lit8 v11, v11, 0x1

    goto :goto_191

    .line 164
    .end local v2    # "adPackagePrefix":Ljava/lang/String;
    .end local v7    # "pkgInfo":Landroid/content/pm/PackageInfo;
    .end local v10    # "service":Landroid/content/pm/ServiceInfo;
    :catch_1e5
    move-exception v6

    .line 165
    .local v6, "e":Ljava/lang/Exception;
    const-string v11, "PornAway"

    const-string v12, "Scan Adware Exception"

    invoke-static {v11, v12, v6}, Lorg/pornaway/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto/16 :goto_16
.end method


# virtual methods
.method public bridge synthetic deliverResult(Ljava/lang/Object;)V
    .registers 2

    .prologue
    .line 41
    check-cast p1, Ljava/util/List;

    invoke-virtual {p0, p1}, Lorg/pornaway/util/ScanAdwareLoader;->deliverResult(Ljava/util/List;)V

    return-void
.end method

.method public deliverResult(Ljava/util/List;)V
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;>;)V"
        }
    .end annotation

    .prologue
    .line 97
    .local p1, "data":Ljava/util/List;, "Ljava/util/List<Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;>;"
    invoke-super {p0, p1}, Landroid/support/v4/content/AsyncTaskLoader;->deliverResult(Ljava/lang/Object;)V

    .line 98
    return-void
.end method

.method public bridge synthetic loadInBackground()Ljava/lang/Object;
    .registers 2

    .prologue
    .line 41
    invoke-virtual {p0}, Lorg/pornaway/util/ScanAdwareLoader;->loadInBackground()Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method public loadInBackground()Ljava/util/List;
    .registers 9
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;>;"
        }
    .end annotation

    .prologue
    .line 59
    invoke-direct {p0}, Lorg/pornaway/util/ScanAdwareLoader;->getAdPackages()Ljava/util/List;

    move-result-object v0

    .line 60
    .local v0, "adPackages":Ljava/util/List;, "Ljava/util/List<Landroid/content/pm/PackageInfo;>;"
    iget-object v5, p0, Lorg/pornaway/util/ScanAdwareLoader;->context:Landroid/content/Context;

    invoke-virtual {v5}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v4

    .line 62
    .local v4, "pm":Landroid/content/pm/PackageManager;
    new-instance v2, Ljava/util/ArrayList;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v5

    invoke-direct {v2, v5}, Ljava/util/ArrayList;-><init>(I)V

    .line 63
    .local v2, "data":Ljava/util/List;, "Ljava/util/List<Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;>;"
    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v5

    :goto_17
    invoke-interface {v5}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_42

    invoke-interface {v5}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroid/content/pm/PackageInfo;

    .line 64
    .local v3, "pkg":Landroid/content/pm/PackageInfo;
    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    .line 65
    .local v1, "attrs":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    const-string v6, "app_name"

    iget-object v7, v3, Landroid/content/pm/PackageInfo;->applicationInfo:Landroid/content/pm/ApplicationInfo;

    invoke-virtual {v4, v7}, Landroid/content/pm/PackageManager;->getApplicationLabel(Landroid/content/pm/ApplicationInfo;)Ljava/lang/CharSequence;

    move-result-object v7

    invoke-interface {v7}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-interface {v1, v6, v7}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 66
    const-string v6, "package_name"

    iget-object v7, v3, Landroid/content/pm/PackageInfo;->packageName:Ljava/lang/String;

    invoke-interface {v1, v6, v7}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 67
    invoke-interface {v2, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_17

    .line 70
    .end local v1    # "attrs":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    .end local v3    # "pkg":Landroid/content/pm/PackageInfo;
    :cond_42
    return-object v2
.end method

.method protected onReset()V
    .registers 2

    .prologue
    .line 75
    invoke-super {p0}, Landroid/support/v4/content/AsyncTaskLoader;->onReset()V

    .line 77
    const/4 v0, 0x1

    iput-boolean v0, p0, Lorg/pornaway/util/ScanAdwareLoader;->canceled:Z

    .line 80
    invoke-virtual {p0}, Lorg/pornaway/util/ScanAdwareLoader;->onStopLoading()V

    .line 81
    return-void
.end method

.method protected onStartLoading()V
    .registers 2

    .prologue
    .line 85
    const/4 v0, 0x0

    iput-boolean v0, p0, Lorg/pornaway/util/ScanAdwareLoader;->canceled:Z

    .line 86
    invoke-virtual {p0}, Lorg/pornaway/util/ScanAdwareLoader;->forceLoad()V

    .line 87
    return-void
.end method

.method protected onStopLoading()V
    .registers 2

    .prologue
    .line 91
    const/4 v0, 0x1

    iput-boolean v0, p0, Lorg/pornaway/util/ScanAdwareLoader;->canceled:Z

    .line 92
    invoke-virtual {p0}, Lorg/pornaway/util/ScanAdwareLoader;->cancelLoad()Z

    .line 93
    return-void
.end method
