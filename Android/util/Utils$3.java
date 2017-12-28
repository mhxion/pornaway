.class final Lorg/pornaway/util/Utils$3;
.super Ljava/lang/Object;
.source "Utils.java"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lorg/pornaway/util/Utils;->rebootQuestion(Landroid/content/Context;II)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation


# instance fields
.field final synthetic val$context:Landroid/content/Context;

.field final synthetic val$dialogView:Landroid/view/View;


# direct methods
.method constructor <init>(Landroid/view/View;Landroid/content/Context;)V
    .registers 3

    .prologue
    .line 143
    iput-object p1, p0, Lorg/pornaway/util/Utils$3;->val$dialogView:Landroid/view/View;

    iput-object p2, p0, Lorg/pornaway/util/Utils$3;->val$context:Landroid/content/Context;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .registers 6
    .param p1, "dialog"    # Landroid/content/DialogInterface;
    .param p2, "id"    # I

    .prologue
    .line 147
    iget-object v1, p0, Lorg/pornaway/util/Utils$3;->val$dialogView:Landroid/view/View;

    const v2, 0x7f0e005b

    .line 148
    invoke-virtual {v1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/CheckBox;

    .line 149
    .local v0, "checkBox":Landroid/widget/CheckBox;
    invoke-virtual {v0}, Landroid/widget/CheckBox;->isChecked()Z

    move-result v1

    if-eqz v1, :cond_17

    .line 150
    iget-object v1, p0, Lorg/pornaway/util/Utils$3;->val$context:Landroid/content/Context;

    const/4 v2, 0x1

    invoke-static {v1, v2}, Lorg/pornaway/helper/PreferenceHelper;->setNeverReboot(Landroid/content/Context;Z)V

    .line 153
    :cond_17
    invoke-interface {p1}, Landroid/content/DialogInterface;->dismiss()V

    .line 154
    return-void
.end method
