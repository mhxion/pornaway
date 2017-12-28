.class Lorg/pornaway/ui/RedirectionListFragment$3;
.super Ljava/lang/Object;
.source "RedirectionListFragment.java"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lorg/pornaway/ui/RedirectionListFragment;->menuAddEntry()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lorg/pornaway/ui/RedirectionListFragment;

.field final synthetic val$hostnameEditText:Landroid/widget/EditText;

.field final synthetic val$ipEditText:Landroid/widget/EditText;


# direct methods
.method constructor <init>(Lorg/pornaway/ui/RedirectionListFragment;Landroid/widget/EditText;Landroid/widget/EditText;)V
    .registers 4
    .param p1, "this$0"    # Lorg/pornaway/ui/RedirectionListFragment;

    .prologue
    .line 276
    iput-object p1, p0, Lorg/pornaway/ui/RedirectionListFragment$3;->this$0:Lorg/pornaway/ui/RedirectionListFragment;

    iput-object p2, p0, Lorg/pornaway/ui/RedirectionListFragment$3;->val$hostnameEditText:Landroid/widget/EditText;

    iput-object p3, p0, Lorg/pornaway/ui/RedirectionListFragment$3;->val$ipEditText:Landroid/widget/EditText;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .registers 6
    .param p1, "dialog"    # Landroid/content/DialogInterface;
    .param p2, "which"    # I

    .prologue
    .line 279
    invoke-interface {p1}, Landroid/content/DialogInterface;->dismiss()V

    .line 281
    iget-object v2, p0, Lorg/pornaway/ui/RedirectionListFragment$3;->val$hostnameEditText:Landroid/widget/EditText;

    invoke-virtual {v2}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    .line 282
    .local v0, "hostname":Ljava/lang/String;
    iget-object v2, p0, Lorg/pornaway/ui/RedirectionListFragment$3;->val$ipEditText:Landroid/widget/EditText;

    invoke-virtual {v2}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    .line 284
    .local v1, "ip":Ljava/lang/String;
    iget-object v2, p0, Lorg/pornaway/ui/RedirectionListFragment$3;->this$0:Lorg/pornaway/ui/RedirectionListFragment;

    # invokes: Lorg/pornaway/ui/RedirectionListFragment;->addEntry(Ljava/lang/String;Ljava/lang/String;)V
    invoke-static {v2, v0, v1}, Lorg/pornaway/ui/RedirectionListFragment;->access$200(Lorg/pornaway/ui/RedirectionListFragment;Ljava/lang/String;Ljava/lang/String;)V

    .line 285
    return-void
.end method
