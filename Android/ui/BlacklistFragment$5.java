.class Lorg/pornaway/ui/BlacklistFragment$5;
.super Ljava/lang/Object;
.source "BlacklistFragment.java"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lorg/pornaway/ui/BlacklistFragment;->addEntry(Ljava/lang/String;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lorg/pornaway/ui/BlacklistFragment;


# direct methods
.method constructor <init>(Lorg/pornaway/ui/BlacklistFragment;)V
    .registers 2
    .param p1, "this$0"    # Lorg/pornaway/ui/BlacklistFragment;

    .prologue
    .line 279
    iput-object p1, p0, Lorg/pornaway/ui/BlacklistFragment$5;->this$0:Lorg/pornaway/ui/BlacklistFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .registers 3
    .param p1, "dlg"    # Landroid/content/DialogInterface;
    .param p2, "sum"    # I

    .prologue
    .line 281
    invoke-interface {p1}, Landroid/content/DialogInterface;->dismiss()V

    .line 282
    return-void
.end method
