.class Lorg/adaway/ui/RedirectionListFragment$6;
.super Ljava/lang/Object;
.source "RedirectionListFragment.java"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lorg/adaway/ui/RedirectionListFragment;->addEntry(Ljava/lang/String;Ljava/lang/String;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lorg/adaway/ui/RedirectionListFragment;


# direct methods
.method constructor <init>(Lorg/adaway/ui/RedirectionListFragment;)V
    .registers 2

    .prologue
    .line 330
    iput-object p1, p0, Lorg/adaway/ui/RedirectionListFragment$6;->this$0:Lorg/adaway/ui/RedirectionListFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .registers 3
    .param p1, "dlg"    # Landroid/content/DialogInterface;
    .param p2, "sum"    # I

    .prologue
    .line 332
    invoke-interface {p1}, Landroid/content/DialogInterface;->dismiss()V

    .line 333
    return-void
.end method
