.class Lorg/pornaway/ui/WhitelistFragment$2;
.super Ljava/lang/Object;
.source "WhitelistFragment.java"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lorg/pornaway/ui/WhitelistFragment;->menuEditEntry(Landroid/widget/AdapterView$AdapterContextMenuInfo;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lorg/pornaway/ui/WhitelistFragment;


# direct methods
.method constructor <init>(Lorg/pornaway/ui/WhitelistFragment;)V
    .registers 2
    .param p1, "this$0"    # Lorg/pornaway/ui/WhitelistFragment;

    .prologue
    .line 172
    iput-object p1, p0, Lorg/pornaway/ui/WhitelistFragment$2;->this$0:Lorg/pornaway/ui/WhitelistFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .registers 3
    .param p1, "dialog"    # Landroid/content/DialogInterface;
    .param p2, "which"    # I

    .prologue
    .line 175
    invoke-interface {p1}, Landroid/content/DialogInterface;->dismiss()V

    .line 176
    return-void
.end method
