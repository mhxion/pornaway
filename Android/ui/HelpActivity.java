.class public Lorg/pornaway/ui/HelpActivity;
.super Lcom/actionbarsherlock/app/SherlockFragmentActivity;
.source "HelpActivity.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lorg/pornaway/ui/HelpActivity$TabsAdapter;
    }
.end annotation


# static fields
.field private static final BITCOIN:Ljava/lang/String; = "1LDEN2cjZ498QYxk14UTJHRakuwxAcggWR"

.field private static final FLATTR_PROJECT_URL:Ljava/lang/String; = "http://code.google.com/p/ad-away/"

.field private static final FLATTR_URL:Ljava/lang/String; = "flattr.com/thing/369138/PornAway-Ad-blocker-for-Android"

.field private static final PAYPAL_CURRENCY_CODE:Ljava/lang/String; = "EUR"

.field private static final PAYPAL_USER:Ljava/lang/String; = "dominik@sufficientlysecure.org"


# instance fields
.field mTabsAdapter:Lorg/pornaway/ui/HelpActivity$TabsAdapter;

.field mViewPager:Landroid/support/v4/view/ViewPager;


# direct methods
.method public constructor <init>()V
    .registers 1

    .prologue
    .line 47
    invoke-direct {p0}, Lcom/actionbarsherlock/app/SherlockFragmentActivity;-><init>()V

    return-void
.end method


# virtual methods
.method public onCreate(Landroid/os/Bundle;)V
    .registers 12
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    const/4 v9, 0x1

    .line 88
    invoke-super {p0, p1}, Lcom/actionbarsherlock/app/SherlockFragmentActivity;->onCreate(Landroid/os/Bundle;)V

    .line 90
    new-instance v6, Landroid/support/v4/view/ViewPager;

    invoke-direct {v6, p0}, Landroid/support/v4/view/ViewPager;-><init>(Landroid/content/Context;)V

    iput-object v6, p0, Lorg/pornaway/ui/HelpActivity;->mViewPager:Landroid/support/v4/view/ViewPager;

    .line 91
    iget-object v6, p0, Lorg/pornaway/ui/HelpActivity;->mViewPager:Landroid/support/v4/view/ViewPager;

    const v7, 0x7f0e0051

    invoke-virtual {v6, v7}, Landroid/support/v4/view/ViewPager;->setId(I)V

    .line 93
    iget-object v6, p0, Lorg/pornaway/ui/HelpActivity;->mViewPager:Landroid/support/v4/view/ViewPager;

    invoke-virtual {p0, v6}, Lorg/pornaway/ui/HelpActivity;->setContentView(Landroid/view/View;)V

    .line 94
    invoke-virtual {p0}, Lorg/pornaway/ui/HelpActivity;->getSupportActionBar()Lcom/actionbarsherlock/app/ActionBar;

    move-result-object v0

    .line 95
    .local v0, "bar":Lcom/actionbarsherlock/app/ActionBar;
    const/4 v6, 0x2

    invoke-virtual {v0, v6}, Lcom/actionbarsherlock/app/ActionBar;->setNavigationMode(I)V

    .line 96
    invoke-virtual {v0, v9}, Lcom/actionbarsherlock/app/ActionBar;->setDisplayShowTitleEnabled(Z)V

    .line 97
    invoke-virtual {v0, v9}, Lcom/actionbarsherlock/app/ActionBar;->setDisplayHomeAsUpEnabled(Z)V

    .line 99
    new-instance v6, Lorg/pornaway/ui/HelpActivity$TabsAdapter;

    iget-object v7, p0, Lorg/pornaway/ui/HelpActivity;->mViewPager:Landroid/support/v4/view/ViewPager;

    invoke-direct {v6, p0, v7}, Lorg/pornaway/ui/HelpActivity$TabsAdapter;-><init>(Lcom/actionbarsherlock/app/SherlockFragmentActivity;Landroid/support/v4/view/ViewPager;)V

    iput-object v6, p0, Lorg/pornaway/ui/HelpActivity;->mTabsAdapter:Lorg/pornaway/ui/HelpActivity$TabsAdapter;

    .line 101
    new-instance v3, Landroid/os/Bundle;

    invoke-direct {v3}, Landroid/os/Bundle;-><init>()V

    .line 102
    .local v3, "faqBundle":Landroid/os/Bundle;
    const-string v6, "htmlFile"

    const v7, 0x7f060002

    invoke-virtual {v3, v6, v7}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 103
    iget-object v6, p0, Lorg/pornaway/ui/HelpActivity;->mTabsAdapter:Lorg/pornaway/ui/HelpActivity$TabsAdapter;

    invoke-virtual {v0}, Lcom/actionbarsherlock/app/ActionBar;->newTab()Lcom/actionbarsherlock/app/ActionBar$Tab;

    move-result-object v7

    const v8, 0x7f08003c

    invoke-virtual {p0, v8}, Lorg/pornaway/ui/HelpActivity;->getString(I)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Lcom/actionbarsherlock/app/ActionBar$Tab;->setText(Ljava/lang/CharSequence;)Lcom/actionbarsherlock/app/ActionBar$Tab;

    move-result-object v7

    const-class v8, Lorg/pornaway/ui/HelpFragmentHtml;

    invoke-virtual {v6, v7, v8, v3}, Lorg/pornaway/ui/HelpActivity$TabsAdapter;->addTab(Lcom/actionbarsherlock/app/ActionBar$Tab;Ljava/lang/Class;Landroid/os/Bundle;)V

    .line 106
    new-instance v4, Landroid/os/Bundle;

    invoke-direct {v4}, Landroid/os/Bundle;-><init>()V

    .line 107
    .local v4, "problemsBundle":Landroid/os/Bundle;
    const-string v6, "htmlFile"

    const v7, 0x7f060003

    invoke-virtual {v4, v6, v7}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 108
    iget-object v6, p0, Lorg/pornaway/ui/HelpActivity;->mTabsAdapter:Lorg/pornaway/ui/HelpActivity$TabsAdapter;

    invoke-virtual {v0}, Lcom/actionbarsherlock/app/ActionBar;->newTab()Lcom/actionbarsherlock/app/ActionBar$Tab;

    move-result-object v7

    const v8, 0x7f08003d

    invoke-virtual {p0, v8}, Lorg/pornaway/ui/HelpActivity;->getString(I)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Lcom/actionbarsherlock/app/ActionBar$Tab;->setText(Ljava/lang/CharSequence;)Lcom/actionbarsherlock/app/ActionBar$Tab;

    move-result-object v7

    const-class v8, Lorg/pornaway/ui/HelpFragmentHtml;

    invoke-virtual {v6, v7, v8, v4}, Lorg/pornaway/ui/HelpActivity$TabsAdapter;->addTab(Lcom/actionbarsherlock/app/ActionBar$Tab;Ljava/lang/Class;Landroid/os/Bundle;)V

    .line 111
    new-instance v5, Landroid/os/Bundle;

    invoke-direct {v5}, Landroid/os/Bundle;-><init>()V

    .line 112
    .local v5, "sOnSOffBundle":Landroid/os/Bundle;
    const-string v6, "htmlFile"

    const v7, 0x7f060004

    invoke-virtual {v5, v6, v7}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 113
    iget-object v6, p0, Lorg/pornaway/ui/HelpActivity;->mTabsAdapter:Lorg/pornaway/ui/HelpActivity$TabsAdapter;

    invoke-virtual {v0}, Lcom/actionbarsherlock/app/ActionBar;->newTab()Lcom/actionbarsherlock/app/ActionBar$Tab;

    move-result-object v7

    const v8, 0x7f08003e

    invoke-virtual {p0, v8}, Lorg/pornaway/ui/HelpActivity;->getString(I)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Lcom/actionbarsherlock/app/ActionBar$Tab;->setText(Ljava/lang/CharSequence;)Lcom/actionbarsherlock/app/ActionBar$Tab;

    move-result-object v7

    const-class v8, Lorg/pornaway/ui/HelpFragmentHtml;

    invoke-virtual {v6, v7, v8, v5}, Lorg/pornaway/ui/HelpActivity$TabsAdapter;->addTab(Lcom/actionbarsherlock/app/ActionBar$Tab;Ljava/lang/Class;Landroid/os/Bundle;)V

    .line 116
    new-instance v2, Landroid/os/Bundle;

    invoke-direct {v2}, Landroid/os/Bundle;-><init>()V

    .line 117
    .local v2, "donationsArgs":Landroid/os/Bundle;
    const-string v6, "debug"

    sget-boolean v7, Lorg/pornaway/util/Constants;->DEBUG:Z

    invoke-virtual {v2, v6, v7}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 118
    const-string v6, "flattrEnabled"

    invoke-virtual {v2, v6, v9}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 119
    const-string v6, "flattrProjectUrl"

    const-string v7, "http://code.google.com/p/ad-away/"

    invoke-virtual {v2, v6, v7}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 120
    const-string v6, "flattrUrl"

    const-string v7, "flattr.com/thing/369138/PornAway-Ad-blocker-for-Android"

    invoke-virtual {v2, v6, v7}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 122
    const-string v6, "paypalEnabled"

    invoke-virtual {v2, v6, v9}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 123
    const-string v6, "paypalCurrencyCode"

    const-string v7, "EUR"

    invoke-virtual {v2, v6, v7}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 124
    const-string v6, "paypalUser"

    const-string v7, "dominik@sufficientlysecure.org"

    invoke-virtual {v2, v6, v7}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 125
    const-string v6, "mPaypalItemName"

    const v7, 0x7f080038

    invoke-virtual {p0, v7}, Lorg/pornaway/ui/HelpActivity;->getString(I)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v2, v6, v7}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 127
    const-string v6, "bitcoinEnabled"

    invoke-virtual {v2, v6, v9}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 128
    const-string v6, "bitcoinAddress"

    const-string v7, "1LDEN2cjZ498QYxk14UTJHRakuwxAcggWR"

    invoke-virtual {v2, v6, v7}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 130
    iget-object v6, p0, Lorg/pornaway/ui/HelpActivity;->mTabsAdapter:Lorg/pornaway/ui/HelpActivity$TabsAdapter;

    invoke-virtual {v0}, Lcom/actionbarsherlock/app/ActionBar;->newTab()Lcom/actionbarsherlock/app/ActionBar$Tab;

    move-result-object v7

    const v8, 0x7f08003b

    invoke-virtual {p0, v8}, Lorg/pornaway/ui/HelpActivity;->getString(I)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Lcom/actionbarsherlock/app/ActionBar$Tab;->setText(Ljava/lang/CharSequence;)Lcom/actionbarsherlock/app/ActionBar$Tab;

    move-result-object v7

    const-class v8, Lorg/sufficientlysecure/donations/DonationsFragment;

    invoke-virtual {v6, v7, v8, v2}, Lorg/pornaway/ui/HelpActivity$TabsAdapter;->addTab(Lcom/actionbarsherlock/app/ActionBar$Tab;Ljava/lang/Class;Landroid/os/Bundle;)V

    .line 133
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 134
    .local v1, "changelogArgs":Landroid/os/Bundle;
    const-string v6, "htmlFile"

    const v7, 0x7f060001

    invoke-virtual {v1, v6, v7}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 135
    iget-object v6, p0, Lorg/pornaway/ui/HelpActivity;->mTabsAdapter:Lorg/pornaway/ui/HelpActivity$TabsAdapter;

    invoke-virtual {v0}, Lcom/actionbarsherlock/app/ActionBar;->newTab()Lcom/actionbarsherlock/app/ActionBar$Tab;

    move-result-object v7

    const v8, 0x7f08003a

    invoke-virtual {p0, v8}, Lorg/pornaway/ui/HelpActivity;->getString(I)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Lcom/actionbarsherlock/app/ActionBar$Tab;->setText(Ljava/lang/CharSequence;)Lcom/actionbarsherlock/app/ActionBar$Tab;

    move-result-object v7

    const-class v8, Lorg/pornaway/ui/HelpFragmentHtml;

    invoke-virtual {v6, v7, v8, v1}, Lorg/pornaway/ui/HelpActivity$TabsAdapter;->addTab(Lcom/actionbarsherlock/app/ActionBar$Tab;Ljava/lang/Class;Landroid/os/Bundle;)V

    .line 138
    iget-object v6, p0, Lorg/pornaway/ui/HelpActivity;->mTabsAdapter:Lorg/pornaway/ui/HelpActivity$TabsAdapter;

    invoke-virtual {v0}, Lcom/actionbarsherlock/app/ActionBar;->newTab()Lcom/actionbarsherlock/app/ActionBar$Tab;

    move-result-object v7

    const v8, 0x7f080039

    invoke-virtual {p0, v8}, Lorg/pornaway/ui/HelpActivity;->getString(I)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Lcom/actionbarsherlock/app/ActionBar$Tab;->setText(Ljava/lang/CharSequence;)Lcom/actionbarsherlock/app/ActionBar$Tab;

    move-result-object v7

    const-class v8, Lorg/pornaway/ui/HelpFragmentAbout;

    const/4 v9, 0x0

    invoke-virtual {v6, v7, v8, v9}, Lorg/pornaway/ui/HelpActivity$TabsAdapter;->addTab(Lcom/actionbarsherlock/app/ActionBar$Tab;Ljava/lang/Class;Landroid/os/Bundle;)V

    .line 140
    return-void
.end method

.method public onOptionsItemSelected(Lcom/actionbarsherlock/view/MenuItem;)Z
    .registers 4
    .param p1, "item"    # Lcom/actionbarsherlock/view/MenuItem;

    .prologue
    .line 74
    invoke-interface {p1}, Lcom/actionbarsherlock/view/MenuItem;->getItemId()I

    move-result v1

    packed-switch v1, :pswitch_data_1e

    .line 82
    invoke-super {p0, p1}, Lcom/actionbarsherlock/app/SherlockFragmentActivity;->onOptionsItemSelected(Lcom/actionbarsherlock/view/MenuItem;)Z

    move-result v1

    :goto_b
    return v1

    .line 77
    :pswitch_c
    new-instance v0, Landroid/content/Intent;

    const-class v1, Lorg/pornaway/ui/BaseActivity;

    invoke-direct {v0, p0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 78
    .local v0, "intent":Landroid/content/Intent;
    const/high16 v1, 0x4000000

    invoke-virtual {v0, v1}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 79
    invoke-virtual {p0, v0}, Lorg/pornaway/ui/HelpActivity;->startActivity(Landroid/content/Intent;)V

    .line 80
    const/4 v1, 0x1

    goto :goto_b

    .line 74
    nop

    :pswitch_data_1e
    .packed-switch 0x102002c
        :pswitch_c
    .end packed-switch
.end method
