.class public Lorg/pornaway/provider/PornAwayContract;
.super Ljava/lang/Object;
.source "PornAwayContract.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lorg/pornaway/provider/PornAwayContract$RedirectionList;,
        Lorg/pornaway/provider/PornAwayContract$Blacklist;,
        Lorg/pornaway/provider/PornAwayContract$Whitelist;,
        Lorg/pornaway/provider/PornAwayContract$HostsSources;,
        Lorg/pornaway/provider/PornAwayContract$RedirectionListColumns;,
        Lorg/pornaway/provider/PornAwayContract$BlacklistColumns;,
        Lorg/pornaway/provider/PornAwayContract$WhitelistColumns;,
        Lorg/pornaway/provider/PornAwayContract$HostsSourcesColumns;
    }
.end annotation


# static fields
.field private static final BASE_CONTENT_URI:Landroid/net/Uri;

.field public static final CONTENT_AUTHORITY:Ljava/lang/String; = "org.pornaway"

.field public static final PATH_BLACKLIST:Ljava/lang/String; = "blacklist"

.field public static final PATH_HOSTS_SOURCES:Ljava/lang/String; = "hostssources"

.field public static final PATH_REDIRECTION_LIST:Ljava/lang/String; = "redirectionlist"

.field public static final PATH_WHITELIST:Ljava/lang/String; = "whitelist"


# direct methods
.method static constructor <clinit>()V
    .registers 1

    .prologue
    .line 53
    const-string v0, "content://org.pornaway"

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    sput-object v0, Lorg/pornaway/provider/PornAwayContract;->BASE_CONTENT_URI:Landroid/net/Uri;

    return-void
.end method

.method private constructor <init>()V
    .registers 1

    .prologue
    .line 175
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 176
    return-void
.end method

.method static synthetic access$000()Landroid/net/Uri;
    .registers 1

    .prologue
    .line 26
    sget-object v0, Lorg/pornaway/provider/PornAwayContract;->BASE_CONTENT_URI:Landroid/net/Uri;

    return-object v0
.end method
