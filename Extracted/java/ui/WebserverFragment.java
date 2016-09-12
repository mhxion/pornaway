.class public Lorg/adaway/ui/WebserverFragment;
.super Lcom/actionbarsherlock/app/SherlockFragment;
.source "WebserverFragment.java"


# instance fields
.field private mActivity:Landroid/app/Activity;

.field private mRootShell:Lorg/sufficientlysecure/rootcommands/Shell;

.field private mWebserverToggle:Landroid/widget/ToggleButton;


# direct methods
.method public constructor <init>()V
    .registers 1

    .prologue
    .line 40
    invoke-direct {p0}, Lcom/actionbarsherlock/app/SherlockFragment;-><init>()V

    return-void
.end method


# virtual methods
.method public onActivityCreated(Landroid/os/Bundle;)V
    .registers 5
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 59
    invoke-super {p0, p1}, Lcom/actionbarsherlock/app/SherlockFragment;->onCreate(Landroid/os/Bundle;)V

    .line 61
    invoke-virtual {p0}, Lorg/adaway/ui/WebserverFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    iput-object v1, p0, Lorg/adaway/ui/WebserverFragment;->mActivity:Landroid/app/Activity;

    .line 62
    iget-object v1, p0, Lorg/adaway/ui/WebserverFragment;->mActivity:Landroid/app/Activity;

    const v2, 0x7f0e0060

    invoke-virtual {v1, v2}, Landroid/app/Activity;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/ToggleButton;

    iput-object v1, p0, Lorg/adaway/ui/WebserverFragment;->mWebserverToggle:Landroid/widget/ToggleButton;

    .line 66
    :try_start_16
    invoke-static {}, Lorg/sufficientlysecure/rootcommands/Shell;->startRootShell()Lorg/sufficientlysecure/rootcommands/Shell;

    move-result-object v1

    iput-object v1, p0, Lorg/adaway/ui/WebserverFragment;->mRootShell:Lorg/sufficientlysecure/rootcommands/Shell;
    :try_end_1c
    .catch Ljava/lang/Exception; {:try_start_16 .. :try_end_1c} :catch_2b

    .line 72
    :goto_1c
    iget-object v1, p0, Lorg/adaway/ui/WebserverFragment;->mRootShell:Lorg/sufficientlysecure/rootcommands/Shell;

    invoke-static {v1}, Lorg/adaway/util/WebserverUtils;->isWebserverRunning(Lorg/sufficientlysecure/rootcommands/Shell;)Z

    move-result v1

    if-eqz v1, :cond_34

    .line 73
    iget-object v1, p0, Lorg/adaway/ui/WebserverFragment;->mWebserverToggle:Landroid/widget/ToggleButton;

    const/4 v2, 0x1

    invoke-virtual {v1, v2}, Landroid/widget/ToggleButton;->setChecked(Z)V

    .line 77
    :goto_2a
    return-void

    .line 67
    :catch_2b
    move-exception v0

    .line 68
    .local v0, "e":Ljava/lang/Exception;
    const-string v1, "AdAway"

    const-string v2, "Problem starting root shell!"

    invoke-static {v1, v2, v0}, Lorg/adaway/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_1c

    .line 75
    .end local v0    # "e":Ljava/lang/Exception;
    :cond_34
    iget-object v1, p0, Lorg/adaway/ui/WebserverFragment;->mWebserverToggle:Landroid/widget/ToggleButton;

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Landroid/widget/ToggleButton;->setChecked(Z)V

    goto :goto_2a
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .registers 6
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 51
    const v0, 0x7f04002c

    const/4 v1, 0x0

    invoke-virtual {p1, v0, p2, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method public onDestroy()V
    .registers 4

    .prologue
    .line 81
    invoke-super {p0}, Lcom/actionbarsherlock/app/SherlockFragment;->onDestroy()V

    .line 84
    :try_start_3
    iget-object v1, p0, Lorg/adaway/ui/WebserverFragment;->mRootShell:Lorg/sufficientlysecure/rootcommands/Shell;

    if-eqz v1, :cond_c

    .line 85
    iget-object v1, p0, Lorg/adaway/ui/WebserverFragment;->mRootShell:Lorg/sufficientlysecure/rootcommands/Shell;

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

.method public webserverOnClick(Landroid/view/View;)V
    .registers 4
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 98
    iget-object v0, p0, Lorg/adaway/ui/WebserverFragment;->mWebserverToggle:Landroid/widget/ToggleButton;

    invoke-virtual {v0}, Landroid/widget/ToggleButton;->isChecked()Z

    move-result v0

    if-eqz v0, :cond_10

    .line 99
    iget-object v0, p0, Lorg/adaway/ui/WebserverFragment;->mActivity:Landroid/app/Activity;

    iget-object v1, p0, Lorg/adaway/ui/WebserverFragment;->mRootShell:Lorg/sufficientlysecure/rootcommands/Shell;

    invoke-static {v0, v1}, Lorg/adaway/util/WebserverUtils;->startWebserver(Landroid/content/Context;Lorg/sufficientlysecure/rootcommands/Shell;)V

    .line 103
    :goto_f
    return-void

    .line 101
    :cond_10
    iget-object v0, p0, Lorg/adaway/ui/WebserverFragment;->mActivity:Landroid/app/Activity;

    iget-object v1, p0, Lorg/adaway/ui/WebserverFragment;->mRootShell:Lorg/sufficientlysecure/rootcommands/Shell;

    invoke-static {v0, v1}, Lorg/adaway/util/WebserverUtils;->stopWebserver(Landroid/content/Context;Lorg/sufficientlysecure/rootcommands/Shell;)V

    goto :goto_f
.end method
