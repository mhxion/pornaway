.class public Lorg/pornaway/util/NotEnoughSpaceException;
.super Ljava/lang/Exception;
.source "NotEnoughSpaceException.java"


# static fields
.field private static final serialVersionUID:J = -0x192941ec4be4fb02L


# direct methods
.method public constructor <init>()V
    .registers 1

    .prologue
    .line 27
    invoke-direct {p0}, Ljava/lang/Exception;-><init>()V

    .line 28
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .registers 2
    .param p1, "msg"    # Ljava/lang/String;

    .prologue
    .line 31
    invoke-direct {p0, p1}, Ljava/lang/Exception;-><init>(Ljava/lang/String;)V

    .line 32
    return-void
.end method
