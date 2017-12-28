.class public Lorg/pornaway/provider/PornAwayContract$RedirectionList;
.super Ljava/lang/Object;
.source "PornAwayContract.java"

# interfaces
.implements Lorg/pornaway/provider/PornAwayContract$RedirectionListColumns;
.implements Landroid/provider/BaseColumns;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/pornaway/provider/PornAwayContract;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "RedirectionList"
.end annotation


# static fields
.field public static final CONTENT_ITEM_TYPE:Ljava/lang/String; = "vnd.android.cursor.item/vnd.pornaway.redirectionlist"

.field public static final CONTENT_TYPE:Ljava/lang/String; = "vnd.android.cursor.dir/vnd.pornaway.redirectionlist"

.field public static final CONTENT_URI:Landroid/net/Uri;

.field public static final DEFAULT_SORT:Ljava/lang/String; = "url ASC"


# direct methods
.method static constructor <clinit>()V
    .registers 2

    .prologue
    .line 148
    # getter for: Lorg/pornaway/provider/PornAwayContract;->BASE_CONTENT_URI:Landroid/net/Uri;
    invoke-static {}, Lorg/pornaway/provider/PornAwayContract;->access$000()Landroid/net/Uri;

    move-result-object v0

    invoke-virtual {v0}, Landroid/net/Uri;->buildUpon()Landroid/net/Uri$Builder;

    move-result-object v0

    const-string v1, "redirectionlist"

    .line 149
    invoke-virtual {v0, v1}, Landroid/net/Uri$Builder;->appendPath(Ljava/lang/String;)Landroid/net/Uri$Builder;

    move-result-object v0

    invoke-virtual {v0}, Landroid/net/Uri$Builder;->build()Landroid/net/Uri;

    move-result-object v0

    sput-object v0, Lorg/pornaway/provider/PornAwayContract$RedirectionList;->CONTENT_URI:Landroid/net/Uri;

    .line 148
    return-void
.end method

.method public constructor <init>()V
    .registers 1

    .prologue
    .line 147
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static buildUri(Ljava/lang/String;)Landroid/net/Uri;
    .registers 2
    .param p0, "id"    # Ljava/lang/String;

    .prologue
    .line 167
    sget-object v0, Lorg/pornaway/provider/PornAwayContract$RedirectionList;->CONTENT_URI:Landroid/net/Uri;

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
    .line 171
    invoke-virtual {p0}, Landroid/net/Uri;->getLastPathSegment()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
