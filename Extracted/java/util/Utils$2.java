.class final Lorg/adaway/util/Utils$2;
.super Ljava/lang/Object;
.source "Utils.java"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lorg/adaway/util/Utils;->rebootQuestion(Landroid/content/Context;II)V
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
    .line 121
    iput-object p1, p0, Lorg/adaway/util/Utils$2;->val$dialogView:Landroid/view/View;

    iput-object p2, p0, Lorg/adaway/util/Utils$2;->val$context:Landroid/content/Context;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .registers 9
    .param p1, "dialog"    # Landroid/content/DialogInterface;
    .param p2, "id"    # I

    .prologue
    .line 125
    iget-object v4, p0, Lorg/adaway/util/Utils$2;->val$dialogView:Landroid/view/View;

    const v5, 0x7f0e0058

    invoke-virtual {v4, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/CheckBox;

    .line 127
    .local v0, "checkBox":Landroid/widget/CheckBox;
    invoke-virtual {v0}, Landroid/widget/CheckBox;->isChecked()Z

    move-result v4

    if-eqz v4, :cond_17

    .line 128
    iget-object v4, p0, Lorg/adaway/util/Utils$2;->val$context:Landroid/content/Context;

    const/4 v5, 0x1

    invoke-static {v4, v5}, Lorg/adaway/helper/PreferenceHelper;->setNeverReboot(Landroid/content/Context;Z)V

    .line 132
    :cond_17
    :try_start_17
    invoke-static {}, Lorg/sufficientlysecure/rootcommands/Shell;->startRootShell()Lorg/sufficientlysecure/rootcommands/Shell;

    move-result-object v2

    .line 134
    .local v2, "rootShell":Lorg/sufficientlysecure/rootcommands/Shell;
    new-instance v3, Lorg/sufficientlysecure/rootcommands/Toolbox;

    invoke-direct {v3, v2}, Lorg/sufficientlysecure/rootcommands/Toolbox;-><init>(Lorg/sufficientlysecure/rootcommands/Shell;)V

    .line 135
    .local v3, "tb":Lorg/sufficientlysecure/rootcommands/Toolbox;
    const/4 v4, 0x2

    invoke-virtual {v3, v4}, Lorg/sufficientlysecure/rootcommands/Toolbox;->reboot(I)V
    :try_end_24
    .catch Ljava/lang/Exception; {:try_start_17 .. :try_end_24} :catch_25

    .line 139
    .end local v2    # "rootShell":Lorg/sufficientlysecure/rootcommands/Shell;
    .end local v3    # "tb":Lorg/sufficientlysecure/rootcommands/Toolbox;
    :goto_24
    return-void

    .line 136
    :catch_25
    move-exception v1

    .line 137
    .local v1, "e":Ljava/lang/Exception;
    const-string v4, "AdAway"

    const-string v5, "Problem with rebooting"

    invoke-static {v4, v5, v1}, Lorg/adaway/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_24
.end method
