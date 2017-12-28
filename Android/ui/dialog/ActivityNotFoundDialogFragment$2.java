.class Lorg/pornaway/ui/dialog/ActivityNotFoundDialogFragment$2;
.super Ljava/lang/Object;
.source "ActivityNotFoundDialogFragment.java"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lorg/pornaway/ui/dialog/ActivityNotFoundDialogFragment;->onCreateDialog(Landroid/os/Bundle;)Landroid/app/Dialog;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lorg/pornaway/ui/dialog/ActivityNotFoundDialogFragment;


# direct methods
.method constructor <init>(Lorg/pornaway/ui/dialog/ActivityNotFoundDialogFragment;)V
    .registers 2
    .param p1, "this$0"    # Lorg/pornaway/ui/dialog/ActivityNotFoundDialogFragment;

    .prologue
    .line 101
    iput-object p1, p0, Lorg/pornaway/ui/dialog/ActivityNotFoundDialogFragment$2;->this$0:Lorg/pornaway/ui/dialog/ActivityNotFoundDialogFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .registers 3
    .param p1, "dialog"    # Landroid/content/DialogInterface;
    .param p2, "id"    # I

    .prologue
    .line 103
    invoke-interface {p1}, Landroid/content/DialogInterface;->dismiss()V

    .line 104
    return-void
.end method
