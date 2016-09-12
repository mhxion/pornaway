.class Lorg/adaway/ui/HostsSourcesFragment$3;
.super Ljava/lang/Object;
.source "HostsSourcesFragment.java"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lorg/adaway/ui/HostsSourcesFragment;->menuAddEntry()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lorg/adaway/ui/HostsSourcesFragment;

.field final synthetic val$inputEditText:Landroid/widget/EditText;


# direct methods
.method constructor <init>(Lorg/adaway/ui/HostsSourcesFragment;Landroid/widget/EditText;)V
    .registers 3

    .prologue
    .line 249
    iput-object p1, p0, Lorg/adaway/ui/HostsSourcesFragment$3;->this$0:Lorg/adaway/ui/HostsSourcesFragment;

    iput-object p2, p0, Lorg/adaway/ui/HostsSourcesFragment$3;->val$inputEditText:Landroid/widget/EditText;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .registers 5
    .param p1, "dialog"    # Landroid/content/DialogInterface;
    .param p2, "which"    # I

    .prologue
    .line 252
    invoke-interface {p1}, Landroid/content/DialogInterface;->dismiss()V

    .line 254
    iget-object v1, p0, Lorg/adaway/ui/HostsSourcesFragment$3;->val$inputEditText:Landroid/widget/EditText;

    invoke-virtual {v1}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    .line 255
    .local v0, "input":Ljava/lang/String;
    iget-object v1, p0, Lorg/adaway/ui/HostsSourcesFragment$3;->this$0:Lorg/adaway/ui/HostsSourcesFragment;

    # invokes: Lorg/adaway/ui/HostsSourcesFragment;->addEntry(Ljava/lang/String;)V
    invoke-static {v1, v0}, Lorg/adaway/ui/HostsSourcesFragment;->access$200(Lorg/adaway/ui/HostsSourcesFragment;Ljava/lang/String;)V

    .line 256
    return-void
.end method
