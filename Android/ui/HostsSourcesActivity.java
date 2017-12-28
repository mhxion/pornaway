.class public Lorg/pornaway/ui/HostsSourcesActivity;
.super Lcom/actionbarsherlock/app/SherlockFragmentActivity;
.source "HostsSourcesActivity.java"


# instance fields
.field private mActionBar:Lcom/actionbarsherlock/app/ActionBar;


# direct methods
.method public constructor <init>()V
    .registers 1

    .prologue
    .line 32
    invoke-direct {p0}, Lcom/actionbarsherlock/app/SherlockFragmentActivity;-><init>()V

    return-void
.end method


# virtual methods
.method protected onCreate(Landroid/os/Bundle;)V
    .registers 4
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    const/4 v1, 0x1

    .line 37
    invoke-super {p0, p1}, Lcom/actionbarsherlock/app/SherlockFragmentActivity;->onCreate(Landroid/os/Bundle;)V

    .line 39
    invoke-virtual {p0}, Lorg/pornaway/ui/HostsSourcesActivity;->getSupportActionBar()Lcom/actionbarsherlock/app/ActionBar;

    move-result-object v0

    iput-object v0, p0, Lorg/pornaway/ui/HostsSourcesActivity;->mActionBar:Lcom/actionbarsherlock/app/ActionBar;

    .line 41
    const v0, 0x7f040020

    invoke-virtual {p0, v0}, Lorg/pornaway/ui/HostsSourcesActivity;->setContentView(I)V

    .line 43
    iget-object v0, p0, Lorg/pornaway/ui/HostsSourcesActivity;->mActionBar:Lcom/actionbarsherlock/app/ActionBar;

    invoke-virtual {v0, v1}, Lcom/actionbarsherlock/app/ActionBar;->setDisplayShowTitleEnabled(Z)V

    .line 44
    iget-object v0, p0, Lorg/pornaway/ui/HostsSourcesActivity;->mActionBar:Lcom/actionbarsherlock/app/ActionBar;

    invoke-virtual {v0, v1}, Lcom/actionbarsherlock/app/ActionBar;->setDisplayHomeAsUpEnabled(Z)V

    .line 45
    return-void
.end method

.method public onOptionsItemSelected(Lcom/actionbarsherlock/view/MenuItem;)Z
    .registers 4
    .param p1, "item"    # Lcom/actionbarsherlock/view/MenuItem;

    .prologue
    .line 52
    invoke-interface {p1}, Lcom/actionbarsherlock/view/MenuItem;->getItemId()I

    move-result v1

    packed-switch v1, :pswitch_data_1e

    .line 60
    invoke-super {p0, p1}, Lcom/actionbarsherlock/app/SherlockFragmentActivity;->onOptionsItemSelected(Lcom/actionbarsherlock/view/MenuItem;)Z

    move-result v1

    :goto_b
    return v1

    .line 55
    :pswitch_c
    new-instance v0, Landroid/content/Intent;

    const-class v1, Lorg/pornaway/ui/BaseActivity;

    invoke-direct {v0, p0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 56
    .local v0, "intent":Landroid/content/Intent;
    const/high16 v1, 0x4000000

    invoke-virtual {v0, v1}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 57
    invoke-virtual {p0, v0}, Lorg/pornaway/ui/HostsSourcesActivity;->startActivity(Landroid/content/Intent;)V

    .line 58
    const/4 v1, 0x1

    goto :goto_b

    .line 52
    nop

    :pswitch_data_1e
    .packed-switch 0x102002c
        :pswitch_c
    .end packed-switch
.end method
