.class Lorg/pornaway/ui/WhitelistFragment$3;
.super Ljava/lang/Object;
.source "WhitelistFragment.java"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lorg/pornaway/ui/WhitelistFragment;->menuAddEntry()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lorg/pornaway/ui/WhitelistFragment;

.field final synthetic val$inputEditText:Landroid/widget/EditText;


# direct methods
.method constructor <init>(Lorg/pornaway/ui/WhitelistFragment;Landroid/widget/EditText;)V
    .registers 3
    .param p1, "this$0"    # Lorg/pornaway/ui/WhitelistFragment;

    .prologue
    .line 247
    iput-object p1, p0, Lorg/pornaway/ui/WhitelistFragment$3;->this$0:Lorg/pornaway/ui/WhitelistFragment;

    iput-object p2, p0, Lorg/pornaway/ui/WhitelistFragment$3;->val$inputEditText:Landroid/widget/EditText;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .registers 5
    .param p1, "dialog"    # Landroid/content/DialogInterface;
    .param p2, "which"    # I

    .prologue
    .line 250
    invoke-interface {p1}, Landroid/content/DialogInterface;->dismiss()V

    .line 252
    iget-object v1, p0, Lorg/pornaway/ui/WhitelistFragment$3;->val$inputEditText:Landroid/widget/EditText;

    invoke-virtual {v1}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    .line 253
    .local v0, "input":Ljava/lang/String;
    iget-object v1, p0, Lorg/pornaway/ui/WhitelistFragment$3;->this$0:Lorg/pornaway/ui/WhitelistFragment;

    # invokes: Lorg/pornaway/ui/WhitelistFragment;->addEntry(Ljava/lang/String;)V
    invoke-static {v1, v0}, Lorg/pornaway/ui/WhitelistFragment;->access$200(Lorg/pornaway/ui/WhitelistFragment;Ljava/lang/String;)V

    .line 254
    return-void
.end method
