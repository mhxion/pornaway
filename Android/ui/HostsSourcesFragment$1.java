.class Lorg/pornaway/ui/HostsSourcesFragment$1;
.super Ljava/lang/Object;
.source "HostsSourcesFragment.java"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lorg/pornaway/ui/HostsSourcesFragment;->menuEditEntry(Landroid/widget/AdapterView$AdapterContextMenuInfo;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lorg/pornaway/ui/HostsSourcesFragment;

.field final synthetic val$inputEditText:Landroid/widget/EditText;


# direct methods
.method constructor <init>(Lorg/pornaway/ui/HostsSourcesFragment;Landroid/widget/EditText;)V
    .registers 3
    .param p1, "this$0"    # Lorg/pornaway/ui/HostsSourcesFragment;

    .prologue
    .line 145
    iput-object p1, p0, Lorg/pornaway/ui/HostsSourcesFragment$1;->this$0:Lorg/pornaway/ui/HostsSourcesFragment;

    iput-object p2, p0, Lorg/pornaway/ui/HostsSourcesFragment$1;->val$inputEditText:Landroid/widget/EditText;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .registers 9
    .param p1, "dialog"    # Landroid/content/DialogInterface;
    .param p2, "which"    # I

    .prologue
    .line 148
    invoke-interface {p1}, Landroid/content/DialogInterface;->dismiss()V

    .line 150
    iget-object v2, p0, Lorg/pornaway/ui/HostsSourcesFragment$1;->val$inputEditText:Landroid/widget/EditText;

    invoke-virtual {v2}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    .line 152
    .local v1, "input":Ljava/lang/String;
    invoke-static {v1}, Lorg/pornaway/util/RegexUtils;->isValidUrl(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_23

    .line 154
    iget-object v2, p0, Lorg/pornaway/ui/HostsSourcesFragment$1;->this$0:Lorg/pornaway/ui/HostsSourcesFragment;

    # getter for: Lorg/pornaway/ui/HostsSourcesFragment;->mActivity:Landroid/app/Activity;
    invoke-static {v2}, Lorg/pornaway/ui/HostsSourcesFragment;->access$000(Lorg/pornaway/ui/HostsSourcesFragment;)Landroid/app/Activity;

    move-result-object v2

    iget-object v3, p0, Lorg/pornaway/ui/HostsSourcesFragment$1;->this$0:Lorg/pornaway/ui/HostsSourcesFragment;

    # getter for: Lorg/pornaway/ui/HostsSourcesFragment;->mCurrentRowId:J
    invoke-static {v3}, Lorg/pornaway/ui/HostsSourcesFragment;->access$100(Lorg/pornaway/ui/HostsSourcesFragment;)J

    move-result-wide v4

    invoke-static {v2, v4, v5, v1}, Lorg/pornaway/provider/ProviderHelper;->updateHostsSourceUrl(Landroid/content/Context;JLjava/lang/String;)V

    .line 169
    :goto_22
    return-void

    .line 156
    :cond_23
    new-instance v2, Landroid/app/AlertDialog$Builder;

    iget-object v3, p0, Lorg/pornaway/ui/HostsSourcesFragment$1;->this$0:Lorg/pornaway/ui/HostsSourcesFragment;

    # getter for: Lorg/pornaway/ui/HostsSourcesFragment;->mActivity:Landroid/app/Activity;
    invoke-static {v3}, Lorg/pornaway/ui/HostsSourcesFragment;->access$000(Lorg/pornaway/ui/HostsSourcesFragment;)Landroid/app/Activity;

    move-result-object v3

    invoke-direct {v2, v3}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    invoke-virtual {v2}, Landroid/app/AlertDialog$Builder;->create()Landroid/app/AlertDialog;

    move-result-object v0

    .line 157
    .local v0, "alertDialog":Landroid/app/AlertDialog;
    const v2, 0x1080027

    invoke-virtual {v0, v2}, Landroid/app/AlertDialog;->setIcon(I)V

    .line 158
    const v2, 0x7f080065

    invoke-virtual {v0, v2}, Landroid/app/AlertDialog;->setTitle(I)V

    .line 159
    iget-object v2, p0, Lorg/pornaway/ui/HostsSourcesFragment$1;->this$0:Lorg/pornaway/ui/HostsSourcesFragment;

    const v3, 0x7f080064

    invoke-virtual {v2, v3}, Lorg/pornaway/ui/HostsSourcesFragment;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Landroid/app/AlertDialog;->setMessage(Ljava/lang/CharSequence;)V

    .line 160
    iget-object v2, p0, Lorg/pornaway/ui/HostsSourcesFragment$1;->this$0:Lorg/pornaway/ui/HostsSourcesFragment;

    const v3, 0x7f08001a

    invoke-virtual {v2, v3}, Lorg/pornaway/ui/HostsSourcesFragment;->getString(I)Ljava/lang/String;

    move-result-object v2

    new-instance v3, Lorg/pornaway/ui/HostsSourcesFragment$1$1;

    invoke-direct {v3, p0}, Lorg/pornaway/ui/HostsSourcesFragment$1$1;-><init>(Lorg/pornaway/ui/HostsSourcesFragment$1;)V

    invoke-virtual {v0, v2, v3}, Landroid/app/AlertDialog;->setButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)V

    .line 167
    invoke-virtual {v0}, Landroid/app/AlertDialog;->show()V

    goto :goto_22
.end method
