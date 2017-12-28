.class public Lorg/pornaway/provider/PornAwayContract$Blacklist;
.super Ljava/lang/Object;
.source "PornAwayContract.java"

# interfaces
.implements Lorg/pornaway/provider/PornAwayContract$BlacklistColumns;
.implements Landroid/provider/BaseColumns;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/pornaway/provider/PornAwayContract;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Blacklist"
.end annotation


# static fields
.field public static final CONTENT_ITEM_TYPE:Ljava/lang/String; = "vnd.android.cursor.item/vnd.pornaway.blacklist"

.field public static final CONTENT_TYPE:Ljava/lang/String; = "vnd.android.cursor.dir/vnd.pornaway.blacklist"

.field public static final CONTENT_URI:Landroid/net/Uri;

.field public static final DEFAULT_SORT:Ljava/lang/String; = "url ASC"


# direct methods
.method static constructor <clinit>()V
    .registers 2

    .prologue
    .line 120
    # getter for: Lorg/pornaway/provider/PornAwayContract;->BASE_CONTENT_URI:Landroid/net/Uri;
    invoke-static {}, Lorg/pornaway/provider/PornAwayContract;->access$000()Landroid/net/Uri;

    move-result-object v0

    invoke-virtual {v0}, Landroid/net/Uri;->buildUpon()Landroid/net/Uri$Builder;

    move-result-object v0

    const-string v1, "blacklist"

    .line 121
    invoke-virtual {v0, v1}, Landroid/net/Uri$Builder;->appendPath(Ljava/lang/String;)Landroid/net/Uri$Builder;

    move-result-object v0

    invoke-virtual {v0}, Landroid/net/Uri$Builder;->build()Landroid/net/Uri;

    move-result-object v0

    sput-object v0, Lorg/pornaway/provider/PornAwayContract$Blacklist;->CONTENT_URI:Landroid/net/Uri;

    .line 120
    return-void
.end method

.method public constructor <init>()V
    .registers 1

    .prologue
    .line 119
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static buildUri(Ljava/lang/String;)Landroid/net/Uri;
    .registers 2
    .param p0, "id"    # Ljava/lang/String;

    .prologue
    .line 139
    sget-object v0, Lorg/pornaway/provider/PornAwayContract$Blacklist;->CONTENT_URI:Landroid/net/Uri;

    invoke-virtual {v0}, Landroid/net/Uri;->buildUpon()Landroid/net/Uri$Builder;

    move-result-object v0

    invoke-virtual {v0, p0}, Landroid/net/Uri$Builder;->appendPath(Ljava/lang/String;)Landroid/net/Uri$Builder;

    move-result-object v0

    invoke-virtual {v0}, Landroid/net/Uri$Builder;->build()Landroid/net/Uri;

    move-result-object v0

    return-object v0
.end method

.method public static getId(Landroid/net/Uri;)Ljava/lang/String;
    .registers 2
    .param p0, "uri"    # Landroid/net/Uri;

    .prologue
    .line 143
    invoke-virtual {p0}, Landroid/net/Uri;->getLastPathSegment()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
