.class final Lorg/pornaway/helper/ResultHelper$2;
.super Ljava/lang/Object;
.source "ResultHelper.java"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lorg/pornaway/helper/ResultHelper;->showDialogBasedOnResult(Landroid/content/Context;ILjava/lang/String;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation


# instance fields
.field final synthetic val$context:Landroid/content/Context;


# direct methods
.method constructor <init>(Landroid/content/Context;)V
    .registers 2

    .prologue
    .line 203
    iput-object p1, p0, Lorg/pornaway/helper/ResultHelper$2;->val$context:Landroid/content/Context;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .registers 4
    .param p1, "dialog"    # Landroid/content/DialogInterface;
    .param p2, "id"    # I

    .prologue
    .line 205
    invoke-interface {p1}, Landroid/content/DialogInterface;->dismiss()V

    .line 207
    iget-object v0, p0, Lorg/pornaway/helper/ResultHelper$2;->val$context:Landroid/content/Context;

    invoke-static {v0}, Lorg/pornaway/ui/BaseActivity;->updateStatusDisabled(Landroid/content/Context;)V

    .line 208
    return-void
.end method
