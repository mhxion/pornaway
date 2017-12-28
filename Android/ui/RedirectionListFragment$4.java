.class Lorg/pornaway/ui/RedirectionListFragment$4;
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


# direct methods
.method constructor <init>(Lorg/pornaway/ui/RedirectionListFragment;)V
    .registers 2
    .param p1, "this$0"    # Lorg/pornaway/ui/RedirectionListFragment;

    .prologue
    .line 289
    iput-object p1, p0, Lorg/pornaway/ui/RedirectionListFragment$4;->this$0:Lorg/pornaway/ui/RedirectionListFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .registers 3
    .param p1, "dialog"    # Landroid/content/DialogInterface;
    .param p2, "which"    # I

    .prologue
    .line 292
    invoke-interface {p1}, Landroid/content/DialogInterface;->dismiss()V

    .line 293
    return-void
.end method
