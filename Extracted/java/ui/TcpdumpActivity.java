.class public Lorg/adaway/ui/TcpdumpActivity;
.super Lcom/actionbarsherlock/app/SherlockActivity;
.source "TcpdumpActivity.java"


# instance fields
.field private mActionBar:Lcom/actionbarsherlock/app/ActionBar;

.field private mActivity:Landroid/app/Activity;

.field private mRootShell:Lorg/sufficientlysecure/rootcommands/Shell;

.field private mTcpdumpToggle:Landroid/widget/ToggleButton;


# direct methods
.method public constructor <init>()V
    .registers 1

    .prologue
    .line 41
    invoke-direct {p0}, Lcom/actionbarsherlock/app/SherlockActivity;-><init>()V

    return-void
.end method


# virtual methods
.method protected onCreate(Landroid/os/Bundle;)V
    .registers 6
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    const/4 v3, 0x1

    .line 53
    invoke-super {p0, p1}, Lcom/actionbarsherlock/app/SherlockActivity;->onCreate(Landroid/os/Bundle;)V

    .line 55
    const v1, 0x7f04002a

    invoke-virtual {p0, v1}, Lorg/adaway/ui/TcpdumpActivity;->setContentView(I)V

    .line 57
    iput-object p0, p0, Lorg/adaway/ui/TcpdumpActivity;->mActivity:Landroid/app/Activity;

    .line 59
    invoke-virtual {p0}, Lorg/adaway/ui/TcpdumpActivity;->getSupportActionBar()Lcom/actionbarsherlock/app/ActionBar;

    move-result-object v1

    iput-object v1, p0, Lorg/adaway/ui/TcpdumpActivity;->mActionBar:Lcom/actionbarsherlock/app/ActionBar;

    .line 60
    iget-object v1, p0, Lorg/adaway/ui/TcpdumpActivity;->mActionBar:Lcom/actionbarsherlock/app/ActionBar;

    invoke-virtual {v1, v3}, Lcom/actionbarsherlock/app/ActionBar;->setDisplayShowTitleEnabled(Z)V

    .line 61
    iget-object v1, p0, Lorg/adaway/ui/TcpdumpActivity;->mActionBar:Lcom/actionbarsherlock/app/ActionBar;

    invoke-virtual {v1, v3}, Lcom/actionbarsherlock/app/ActionBar;->setDisplayHomeAsUpEnabled(Z)V

    .line 63
    iget-object v1, p0, Lorg/adaway/ui/TcpdumpActivity;->mActivity:Landroid/app/Activity;

    const v2, 0x7f0e005b

    invoke-virtual {v1, v2}, Landroid/app/Activity;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/ToggleButton;

    iput-object v1, p0, Lorg/adaway/ui/TcpdumpActivity;->mTcpdumpToggle:Landroid/widget/ToggleButton;

    .line 66
    :try_start_29
    invoke-static {}, Lorg/sufficientlysecure/rootcommands/Shell;->startRootShell()Lorg/sufficientlysecure/rootcommands/Shell;

    move-result-object v1

    iput-object v1, p0, Lorg/adaway/ui/TcpdumpActivity;->mRootShell:Lorg/sufficientlysecure/rootcommands/Shell;
    :try_end_2f
    .catch Ljava/lang/Exception; {:try_start_29 .. :try_end_2f} :catch_3d

    .line 72
    :goto_2f
    iget-object v1, p0, Lorg/adaway/ui/TcpdumpActivity;->mRootShell:Lorg/sufficientlysecure/rootcommands/Shell;

    invoke-static {v1}, Lorg/adaway/util/TcpdumpUtils;->isTcpdumpRunning(Lorg/sufficientlysecure/rootcommands/Shell;)Z

    move-result v1

    if-eqz v1, :cond_46

    .line 73
    iget-object v1, p0, Lorg/adaway/ui/TcpdumpActivity;->mTcpdumpToggle:Landroid/widget/ToggleButton;

    invoke-virtual {v1, v3}, Landroid/widget/ToggleButton;->setChecked(Z)V

    .line 77
    :goto_3c
    return-void

    .line 67
    :catch_3d
    move-exception v0

    .line 68
    .local v0, "e":Ljava/lang/Exception;
    const-string v1, "AdAway"

    const-string v2, "Problem while starting shell!"

    invoke-static {v1, v2, v0}, Lorg/adaway/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_2f

    .line 75
    .end local v0    # "e":Ljava/lang/Exception;
    :cond_46
    iget-object v1, p0, Lorg/adaway/ui/TcpdumpActivity;->mTcpdumpToggle:Landroid/widget/ToggleButton;

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Landroid/widget/ToggleButton;->setChecked(Z)V

    goto :goto_3c
.end method

.method public onDestroy()V
    .registers 4

    .prologue
    .line 81
    invoke-super {p0}, Lcom/actionbarsherlock/app/SherlockActivity;->onDestroy()V

    .line 84
    :try_start_3
    iget-object v1, p0, Lorg/adaway/ui/TcpdumpActivity;->mRootShell:Lorg/sufficientlysecure/rootcommands/Shell;

    if-eqz v1, :cond_c

    .line 85
    iget-object v1, p0, Lorg/adaway/ui/TcpdumpActivity;->mRootShell:Lorg/sufficientlysecure/rootcommands/Shell;

    invoke-virtual {v1}, Lorg/sufficientlysecure/rootcommands/Shell;->close()V
    :try_end_c
    .catch Ljava/io/IOException; {:try_start_3 .. :try_end_c} :catch_d

    .line 90
    :cond_c
    :goto_c
    return-void

    .line 87
    :catch_d
    move-exception v0

    .line 88
    .local v0, "e":Ljava/io/IOException;
    const-string v1, "AdAway"

    const-string v2, "Problem while closing shell!"

    invoke-static {v1, v2, v0}, Lorg/adaway/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_c
.end method

.method public onOptionsItemSelected(Lcom/actionbarsherlock/view/MenuItem;)Z
    .registers 5
    .param p1, "item"    # Lcom/actionbarsherlock/view/MenuItem;

    .prologue
    .line 97
    invoke-interface {p1}, Lcom/actionbarsherlock/view/MenuItem;->getItemId()I

    move-result v1

    packed-switch v1, :pswitch_data_20

    .line 106
    invoke-super {p0, p1}, Lcom/actionbarsherlock/app/SherlockActivity;->onOptionsItemSelected(Lcom/actionbarsherlock/view/MenuItem;)Z

    move-result v1

    :goto_b
    return v1

    .line 100
    :pswitch_c
    new-instance v0, Landroid/content/Intent;

    iget-object v1, p0, Lorg/adaway/ui/TcpdumpActivity;->mActivity:Landroid/app/Activity;

    const-class v2, Lorg/adaway/ui/BaseActivity;

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 101
    .local v0, "intent":Landroid/content/Intent;
    const/high16 v1, 0x4000000

    invoke-virtual {v0, v1}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 102
    invoke-virtual {p0, v0}, Lorg/adaway/ui/TcpdumpActivity;->startActivity(Landroid/content/Intent;)V

    .line 103
    const/4 v1, 0x1

    goto :goto_b

    .line 97
    nop

    :pswitch_data_20
    .packed-switch 0x102002c
        :pswitch_c
    .end packed-switch
.end method

.method public tcpdumpDeleteOnClick(Landroid/view/View;)V
    .registers 3
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 126
    iget-object v0, p0, Lorg/adaway/ui/TcpdumpActivity;->mActivity:Landroid/app/Activity;

    invoke-static {v0}, Lorg/adaway/util/TcpdumpUtils;->deleteLog(Landroid/content/Context;)V

    .line 127
    return-void
.end method

.method public tcpdumpOpenOnClick(Landroid/view/View;)V
    .registers 5
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 122
    new-instance v0, Landroid/content/Intent;

    iget-object v1, p0, Lorg/adaway/ui/TcpdumpActivity;->mActivity:Landroid/app/Activity;

    const-class v2, Lorg/adaway/ui/TcpdumpLogActivity;

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    invoke-virtual {p0, v0}, Lorg/adaway/ui/TcpdumpActivity;->startActivity(Landroid/content/Intent;)V

    .line 123
    return-void
.end method

.method public tcpdumpToggleOnClick(Landroid/view/View;)V
    .registers 4
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 111
    iget-object v0, p0, Lorg/adaway/ui/TcpdumpActivity;->mTcpdumpToggle:Landroid/widget/ToggleButton;

    invoke-virtual {v0}, Landroid/widget/ToggleButton;->isChecked()Z

    move-result v0

    if-eqz v0, :cond_19

    .line 113
    iget-object v0, p0, Lorg/adaway/ui/TcpdumpActivity;->mActivity:Landroid/app/Activity;

    iget-object v1, p0, Lorg/adaway/ui/TcpdumpActivity;->mRootShell:Lorg/sufficientlysecure/rootcommands/Shell;

    invoke-static {v0, v1}, Lorg/adaway/util/TcpdumpUtils;->startTcpdump(Landroid/content/Context;Lorg/sufficientlysecure/rootcommands/Shell;)Z

    move-result v0

    if-nez v0, :cond_18

    .line 114
    iget-object v0, p0, Lorg/adaway/ui/TcpdumpActivity;->mTcpdumpToggle:Landroid/widget/ToggleButton;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/ToggleButton;->setChecked(Z)V

    .line 119
    :cond_18
    :goto_18
    return-void

    .line 117
    :cond_19
    iget-object v0, p0, Lorg/adaway/ui/TcpdumpActivity;->mActivity:Landroid/app/Activity;

    iget-object v1, p0, Lorg/adaway/ui/TcpdumpActivity;->mRootShell:Lorg/sufficientlysecure/rootcommands/Shell;

    invoke-static {v0, v1}, Lorg/adaway/util/TcpdumpUtils;->stopTcpdump(Landroid/content/Context;Lorg/sufficientlysecure/rootcommands/Shell;)V

    goto :goto_18
.end method
