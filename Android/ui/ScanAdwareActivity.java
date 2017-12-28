.class public Lorg/pornaway/ui/ScanAdwareActivity;
.super Lcom/actionbarsherlock/app/SherlockFragmentActivity;
.source "ScanAdwareActivity.java"


# instance fields
.field private mActionBar:Lcom/actionbarsherlock/app/ActionBar;

.field private mActivity:Landroid/app/Activity;


# direct methods
.method public constructor <init>()V
    .registers 1

    .prologue
    .line 36
    invoke-direct {p0}, Lcom/actionbarsherlock/app/SherlockFragmentActivity;-><init>()V

    return-void
.end method


# virtual methods
.method protected onCreate(Landroid/os/Bundle;)V
    .registers 4
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    const/4 v1, 0x1

    .line 45
    invoke-super {p0, p1}, Lcom/actionbarsherlock/app/SherlockFragmentActivity;->onCreate(Landroid/os/Bundle;)V

    .line 47
    const v0, 0x7f040028

    invoke-virtual {p0, v0}, Lorg/pornaway/ui/ScanAdwareActivity;->setContentView(I)V

    .line 49
    iput-object p0, p0, Lorg/pornaway/ui/ScanAdwareActivity;->mActivity:Landroid/app/Activity;

    .line 51
    invoke-virtual {p0}, Lorg/pornaway/ui/ScanAdwareActivity;->getSupportActionBar()Lcom/actionbarsherlock/app/ActionBar;

    move-result-object v0

    iput-object v0, p0, Lorg/pornaway/ui/ScanAdwareActivity;->mActionBar:Lcom/actionbarsherlock/app/ActionBar;

    .line 52
    iget-object v0, p0, Lorg/pornaway/ui/ScanAdwareActivity;->mActionBar:Lcom/actionbarsherlock/app/ActionBar;

    invoke-virtual {v0, v1}, Lcom/actionbarsherlock/app/ActionBar;->setDisplayShowTitleEnabled(Z)V

    .line 53
    iget-object v0, p0, Lorg/pornaway/ui/ScanAdwareActivity;->mActionBar:Lcom/actionbarsherlock/app/ActionBar;

    invoke-virtual {v0, v1}, Lcom/actionbarsherlock/app/ActionBar;->setDisplayHomeAsUpEnabled(Z)V

    .line 54
    return-void
.end method

.method public onOptionsItemSelected(Lcom/actionbarsherlock/view/MenuItem;)Z
    .registers 5
    .param p1, "item"    # Lcom/actionbarsherlock/view/MenuItem;

    .prologue
    .line 61
    invoke-interface {p1}, Lcom/actionbarsherlock/view/MenuItem;->getItemId()I

    move-result v1

    packed-switch v1, :pswitch_data_20

    .line 70
    invoke-super {p0, p1}, Lcom/actionbarsherlock/app/SherlockFragmentActivity;->onOptionsItemSelected(Lcom/actionbarsherlock/view/MenuItem;)Z

    move-result v1

    :goto_b
    return v1

    .line 64
    :pswitch_c
    new-instance v0, Landroid/content/Intent;

    iget-object v1, p0, Lorg/pornaway/ui/ScanAdwareActivity;->mActivity:Landroid/app/Activity;

    const-class v2, Lorg/pornaway/ui/BaseActivity;

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 65
    .local v0, "intent":Landroid/content/Intent;
    const/high16 v1, 0x4000000

    invoke-virtual {v0, v1}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 66
    invoke-virtual {p0, v0}, Lorg/pornaway/ui/ScanAdwareActivity;->startActivity(Landroid/content/Intent;)V

    .line 67
    const/4 v1, 0x1

    goto :goto_b

    .line 61
    nop

    :pswitch_data_20
    .packed-switch 0x102002c
        :pswitch_c
    .end packed-switch
.end method

.method public scanAdwareStartOnClick(Landroid/view/View;)V
    .registers 6
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 76
    invoke-virtual {p0}, Lorg/pornaway/ui/ScanAdwareActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    .line 77
    .local v0, "fragmentManager":Landroid/support/v4/app/FragmentManager;
    invoke-virtual {v0}, Landroid/support/v4/app/FragmentManager;->beginTransaction()Landroid/support/v4/app/FragmentTransaction;

    move-result-object v1

    .line 79
    .local v1, "fragmentTransaction":Landroid/support/v4/app/FragmentTransaction;
    new-instance v2, Lorg/pornaway/ui/ScanAdwareListFragment;

    invoke-direct {v2}, Lorg/pornaway/ui/ScanAdwareListFragment;-><init>()V

    .line 81
    .local v2, "listFragment":Lorg/pornaway/ui/ScanAdwareListFragment;
    const v3, 0x7f0e005d

    invoke-virtual {v1, v3, v2}, Landroid/support/v4/app/FragmentTransaction;->replace(ILandroid/support/v4/app/Fragment;)Landroid/support/v4/app/FragmentTransaction;

    .line 82
    invoke-virtual {v1}, Landroid/support/v4/app/FragmentTransaction;->commit()I

    .line 83
    return-void
.end method
