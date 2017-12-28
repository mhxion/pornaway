.class public Lorg/pornaway/util/SystemlessUtils$SystemlessModeStatus;
.super Ljava/lang/Object;
.source "SystemlessUtils.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/pornaway/util/SystemlessUtils;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SystemlessModeStatus"
.end annotation


# instance fields
.field private final enabled:Z

.field private final supported:Z


# direct methods
.method public constructor <init>(ZZ)V
    .registers 3
    .param p1, "supported"    # Z
    .param p2, "enabled"    # Z

    .prologue
    .line 183
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 184
    iput-boolean p1, p0, Lorg/pornaway/util/SystemlessUtils$SystemlessModeStatus;->supported:Z

    .line 185
    iput-boolean p2, p0, Lorg/pornaway/util/SystemlessUtils$SystemlessModeStatus;->enabled:Z

    .line 186
    return-void
.end method


# virtual methods
.method public isEnabled()Z
    .registers 2

    .prologue
    .line 203
    iget-boolean v0, p0, Lorg/pornaway/util/SystemlessUtils$SystemlessModeStatus;->enabled:Z

    return v0
.end method

.method public isSupported()Z
    .registers 2

    .prologue
    .line 194
    iget-boolean v0, p0, Lorg/pornaway/util/SystemlessUtils$SystemlessModeStatus;->supported:Z

    return v0
.end method
