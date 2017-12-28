.class public Lorg/pornaway/ui/PrefsActivity;
.super Lcom/actionbarsherlock/app/SherlockPreferenceActivity;
.source "PrefsActivity.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lorg/pornaway/ui/PrefsActivity$SystemlessCheckTask;
    }
.end annotation


# instance fields
.field private mActionBar:Lcom/actionbarsherlock/app/ActionBar;

.field private mActivity:Landroid/content/Context;

.field private mCustomTarget:Landroid/preference/EditTextPreference;

.field private mSystemless:Landroid/preference/CheckBoxPreference;

.field private mUpdateCheckDaily:Landroid/preference/CheckBoxPreference;

.field private mWebserverOnBoot:Landroid/preference/CheckBoxPreference;


# direct methods
.method public constructor <init>()V
    .registers 1

    .prologue
    .line 48
    invoke-direct {p0}, Lcom/actionbarsherlock/app/SherlockPreferenceActivity;-><init>()V

    return-void
.end method

.method static synthetic access$000(Lorg/pornaway/ui/PrefsActivity;)Landroid/content/Context;
    .registers 2
    .param p0, "x0"    # Lorg/pornaway/ui/PrefsActivity;

    .prologue
    .line 48
    iget-object v0, p0, Lorg/pornaway/ui/PrefsActivity;->mActivity:Landroid/content/Context;

    return-object v0
.end method

.method static synthetic access$200(Lorg/pornaway/ui/PrefsActivity;)Landroid/preference/EditTextPreference;
    .registers 2
    .param p0, "x0"    # Lorg/pornaway/ui/PrefsActivity;

    .prologue
    .line 48
    iget-object v0, p0, Lorg/pornaway/ui/PrefsActivity;->mCustomTarget:Landroid/preference/EditTextPreference;

    return-object v0
.end method

.method static synthetic access$300(Lorg/pornaway/ui/PrefsActivity;)Landroid/preference/CheckBoxPreference;
    .registers 2
    .param p0, "x0"    # Lorg/pornaway/ui/PrefsActivity;

    .prologue
    .line 48
    iget-object v0, p0, Lorg/pornaway/ui/PrefsActivity;->mSystemless:Landroid/preference/CheckBoxPreference;

    return-object v0
.end method


# virtual methods
.method public onCreate(Landroid/os/Bundle;)V
    .registers 13
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    const v10, 0x7f0800f0

    const v9, 0x7f0800c7

    const v8, 0x7f080078

    const/4 v7, 0x0

    const/4 v6, 0x1

    .line 79
    invoke-super {p0, p1}, Lcom/actionbarsherlock/app/SherlockPreferenceActivity;->onCreate(Landroid/os/Bundle;)V

    .line 81
    iput-object p0, p0, Lorg/pornaway/ui/PrefsActivity;->mActivity:Landroid/content/Context;

    .line 82
    invoke-virtual {p0}, Lorg/pornaway/ui/PrefsActivity;->getSupportActionBar()Lcom/actionbarsherlock/app/ActionBar;

    move-result-object v4

    iput-object v4, p0, Lorg/pornaway/ui/PrefsActivity;->mActionBar:Lcom/actionbarsherlock/app/ActionBar;

    .line 84
    iget-object v4, p0, Lorg/pornaway/ui/PrefsActivity;->mActionBar:Lcom/actionbarsherlock/app/ActionBar;

    invoke-virtual {v4, v6}, Lcom/actionbarsherlock/app/ActionBar;->setDisplayShowTitleEnabled(Z)V

    .line 85
    iget-object v4, p0, Lorg/pornaway/ui/PrefsActivity;->mActionBar:Lcom/actionbarsherlock/app/ActionBar;

    invoke-virtual {v4, v6}, Lcom/actionbarsherlock/app/ActionBar;->setDisplayHomeAsUpEnabled(Z)V

    .line 87
    invoke-virtual {p0}, Lorg/pornaway/ui/PrefsActivity;->getPreferenceManager()Landroid/preference/PreferenceManager;

    move-result-object v4

    const-string v5, "preferences"

    invoke-virtual {v4, v5}, Landroid/preference/PreferenceManager;->setSharedPreferencesName(Ljava/lang/String;)V

    .line 88
    const/high16 v4, 0x7f050000

    invoke-virtual {p0, v4}, Lorg/pornaway/ui/PrefsActivity;->addPreferencesFromResource(I)V

    .line 93
    invoke-virtual {p0, v9}, Lorg/pornaway/ui/PrefsActivity;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {p0, v4}, Lorg/pornaway/ui/PrefsActivity;->findPreference(Ljava/lang/CharSequence;)Landroid/preference/Preference;

    move-result-object v0

    .line 94
    .local v0, "SystemlessPref":Landroid/preference/Preference;
    new-instance v4, Lorg/pornaway/ui/PrefsActivity$1;

    invoke-direct {v4, p0}, Lorg/pornaway/ui/PrefsActivity$1;-><init>(Lorg/pornaway/ui/PrefsActivity;)V

    invoke-virtual {v0, v4}, Landroid/preference/Preference;->setOnPreferenceChangeListener(Landroid/preference/Preference$OnPreferenceChangeListener;)V

    .line 123
    invoke-virtual {p0, v10}, Lorg/pornaway/ui/PrefsActivity;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {p0, v4}, Lorg/pornaway/ui/PrefsActivity;->findPreference(Ljava/lang/CharSequence;)Landroid/preference/Preference;

    move-result-object v1

    .line 124
    .local v1, "UpdateDailyPref":Landroid/preference/Preference;
    new-instance v4, Lorg/pornaway/ui/PrefsActivity$2;

    invoke-direct {v4, p0}, Lorg/pornaway/ui/PrefsActivity$2;-><init>(Lorg/pornaway/ui/PrefsActivity;)V

    invoke-virtual {v1, v4}, Landroid/preference/Preference;->setOnPreferenceClickListener(Landroid/preference/Preference$OnPreferenceClickListener;)V

    .line 139
    const v4, 0x7f0800f6

    invoke-virtual {p0, v4}, Lorg/pornaway/ui/PrefsActivity;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {p0, v4}, Lorg/pornaway/ui/PrefsActivity;->findPreference(Ljava/lang/CharSequence;)Landroid/preference/Preference;

    move-result-object v2

    .line 140
    .local v2, "WebserverEnabledPref":Landroid/preference/Preference;
    new-instance v4, Lorg/pornaway/ui/PrefsActivity$3;

    invoke-direct {v4, p0}, Lorg/pornaway/ui/PrefsActivity$3;-><init>(Lorg/pornaway/ui/PrefsActivity;)V

    invoke-virtual {v2, v4}, Landroid/preference/Preference;->setOnPreferenceChangeListener(Landroid/preference/Preference$OnPreferenceChangeListener;)V

    .line 165
    invoke-virtual {p0}, Lorg/pornaway/ui/PrefsActivity;->getPreferenceScreen()Landroid/preference/PreferenceScreen;

    move-result-object v4

    invoke-virtual {p0, v9}, Lorg/pornaway/ui/PrefsActivity;->getString(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Landroid/preference/PreferenceScreen;->findPreference(Ljava/lang/CharSequence;)Landroid/preference/Preference;

    move-result-object v4

    check-cast v4, Landroid/preference/CheckBoxPreference;

    iput-object v4, p0, Lorg/pornaway/ui/PrefsActivity;->mSystemless:Landroid/preference/CheckBoxPreference;

    .line 167
    new-instance v4, Lorg/pornaway/ui/PrefsActivity$SystemlessCheckTask;

    const/4 v5, 0x0

    invoke-direct {v4, p0, v5}, Lorg/pornaway/ui/PrefsActivity$SystemlessCheckTask;-><init>(Lorg/pornaway/ui/PrefsActivity;Lorg/pornaway/ui/PrefsActivity$1;)V

    new-array v5, v7, [Ljava/lang/Void;

    invoke-virtual {v4, v5}, Lorg/pornaway/ui/PrefsActivity$SystemlessCheckTask;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 170
    invoke-virtual {p0}, Lorg/pornaway/ui/PrefsActivity;->getPreferenceScreen()Landroid/preference/PreferenceScreen;

    move-result-object v4

    const v5, 0x7f0800e2

    .line 171
    invoke-virtual {p0, v5}, Lorg/pornaway/ui/PrefsActivity;->getString(I)Ljava/lang/String;

    move-result-object v5

    .line 170
    invoke-virtual {v4, v5}, Landroid/preference/PreferenceScreen;->findPreference(Ljava/lang/CharSequence;)Landroid/preference/Preference;

    move-result-object v4

    check-cast v4, Landroid/preference/EditTextPreference;

    iput-object v4, p0, Lorg/pornaway/ui/PrefsActivity;->mCustomTarget:Landroid/preference/EditTextPreference;

    .line 174
    iget-object v4, p0, Lorg/pornaway/ui/PrefsActivity;->mActivity:Landroid/content/Context;

    invoke-static {v4}, Lorg/pornaway/helper/PreferenceHelper;->getApplyMethod(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v4

    const-string v5, "customTarget"

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_f3

    .line 175
    iget-object v4, p0, Lorg/pornaway/ui/PrefsActivity;->mCustomTarget:Landroid/preference/EditTextPreference;

    invoke-virtual {v4, v6}, Landroid/preference/EditTextPreference;->setEnabled(Z)V

    .line 181
    :goto_a2
    const v4, 0x7f0800de

    invoke-virtual {p0, v4}, Lorg/pornaway/ui/PrefsActivity;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {p0, v4}, Lorg/pornaway/ui/PrefsActivity;->findPreference(Ljava/lang/CharSequence;)Landroid/preference/Preference;

    move-result-object v3

    .line 182
    .local v3, "customTargetPref":Landroid/preference/Preference;
    new-instance v4, Lorg/pornaway/ui/PrefsActivity$4;

    invoke-direct {v4, p0}, Lorg/pornaway/ui/PrefsActivity$4;-><init>(Lorg/pornaway/ui/PrefsActivity;)V

    invoke-virtual {v3, v4}, Landroid/preference/Preference;->setOnPreferenceChangeListener(Landroid/preference/Preference$OnPreferenceChangeListener;)V

    .line 198
    invoke-virtual {p0}, Lorg/pornaway/ui/PrefsActivity;->getPreferenceScreen()Landroid/preference/PreferenceScreen;

    move-result-object v4

    .line 199
    invoke-virtual {p0, v10}, Lorg/pornaway/ui/PrefsActivity;->getString(I)Ljava/lang/String;

    move-result-object v5

    .line 198
    invoke-virtual {v4, v5}, Landroid/preference/PreferenceScreen;->findPreference(Ljava/lang/CharSequence;)Landroid/preference/Preference;

    move-result-object v4

    check-cast v4, Landroid/preference/CheckBoxPreference;

    iput-object v4, p0, Lorg/pornaway/ui/PrefsActivity;->mUpdateCheckDaily:Landroid/preference/CheckBoxPreference;

    .line 200
    invoke-virtual {p0}, Lorg/pornaway/ui/PrefsActivity;->getPreferenceScreen()Landroid/preference/PreferenceScreen;

    move-result-object v4

    const v5, 0x7f0800f8

    .line 201
    invoke-virtual {p0, v5}, Lorg/pornaway/ui/PrefsActivity;->getString(I)Ljava/lang/String;

    move-result-object v5

    .line 200
    invoke-virtual {v4, v5}, Landroid/preference/PreferenceScreen;->findPreference(Ljava/lang/CharSequence;)Landroid/preference/Preference;

    move-result-object v4

    check-cast v4, Landroid/preference/CheckBoxPreference;

    iput-object v4, p0, Lorg/pornaway/ui/PrefsActivity;->mWebserverOnBoot:Landroid/preference/CheckBoxPreference;

    .line 203
    invoke-static {p0}, Lorg/pornaway/util/Utils;->isInstalledOnSdCard(Landroid/content/Context;)Z

    move-result v4

    if-eqz v4, :cond_f9

    .line 204
    iget-object v4, p0, Lorg/pornaway/ui/PrefsActivity;->mUpdateCheckDaily:Landroid/preference/CheckBoxPreference;

    invoke-virtual {v4, v7}, Landroid/preference/CheckBoxPreference;->setEnabled(Z)V

    .line 205
    iget-object v4, p0, Lorg/pornaway/ui/PrefsActivity;->mWebserverOnBoot:Landroid/preference/CheckBoxPreference;

    invoke-virtual {v4, v7}, Landroid/preference/CheckBoxPreference;->setEnabled(Z)V

    .line 206
    iget-object v4, p0, Lorg/pornaway/ui/PrefsActivity;->mUpdateCheckDaily:Landroid/preference/CheckBoxPreference;

    invoke-virtual {v4, v8}, Landroid/preference/CheckBoxPreference;->setSummary(I)V

    .line 207
    iget-object v4, p0, Lorg/pornaway/ui/PrefsActivity;->mWebserverOnBoot:Landroid/preference/CheckBoxPreference;

    invoke-virtual {v4, v8}, Landroid/preference/CheckBoxPreference;->setSummary(I)V

    .line 215
    :goto_f2
    return-void

    .line 177
    .end local v3    # "customTargetPref":Landroid/preference/Preference;
    :cond_f3
    iget-object v4, p0, Lorg/pornaway/ui/PrefsActivity;->mCustomTarget:Landroid/preference/EditTextPreference;

    invoke-virtual {v4, v7}, Landroid/preference/EditTextPreference;->setEnabled(Z)V

    goto :goto_a2

    .line 209
    .restart local v3    # "customTargetPref":Landroid/preference/Preference;
    :cond_f9
    iget-object v4, p0, Lorg/pornaway/ui/PrefsActivity;->mUpdateCheckDaily:Landroid/preference/CheckBoxPreference;

    invoke-virtual {v4, v6}, Landroid/preference/CheckBoxPreference;->setEnabled(Z)V

    .line 210
    iget-object v4, p0, Lorg/pornaway/ui/PrefsActivity;->mWebserverOnBoot:Landroid/preference/CheckBoxPreference;

    invoke-virtual {v4, v6}, Landroid/preference/CheckBoxPreference;->setEnabled(Z)V

    .line 211
    iget-object v4, p0, Lorg/pornaway/ui/PrefsActivity;->mUpdateCheckDaily:Landroid/preference/CheckBoxPreference;

    const v5, 0x7f08007b

    invoke-virtual {v4, v5}, Landroid/preference/CheckBoxPreference;->setSummary(I)V

    .line 212
    iget-object v4, p0, Lorg/pornaway/ui/PrefsActivity;->mWebserverOnBoot:Landroid/preference/CheckBoxPreference;

    const v5, 0x7f080083

    invoke-virtual {v4, v5}, Landroid/preference/CheckBoxPreference;->setSummary(I)V

    goto :goto_f2
.end method

.method public onOptionsItemSelected(Lcom/actionbarsherlock/view/MenuItem;)Z
    .registers 4
    .param p1, "item"    # Lcom/actionbarsherlock/view/MenuItem;

    .prologue
    .line 62
    invoke-interface {p1}, Lcom/actionbarsherlock/view/MenuItem;->getItemId()I

    move-result v1

    packed-switch v1, :pswitch_data_1e

    .line 70
    invoke-super {p0, p1}, Lcom/actionbarsherlock/app/SherlockPreferenceActivity;->onOptionsItemSelected(Lcom/actionbarsherlock/view/MenuItem;)Z

    move-result v1

    :goto_b
    return v1

    .line 65
    :pswitch_c
    new-instance v0, Landroid/content/Intent;

    const-class v1, Lorg/pornaway/ui/BaseActivity;

    invoke-direct {v0, p0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 66
    .local v0, "intent":Landroid/content/Intent;
    const/high16 v1, 0x4000000

    invoke-virtual {v0, v1}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 67
    invoke-virtual {p0, v0}, Lorg/pornaway/ui/PrefsActivity;->startActivity(Landroid/content/Intent;)V

    .line 68
    const/4 v1, 0x1

    goto :goto_b

    .line 62
    nop

    :pswitch_data_1e
    .packed-switch 0x102002c
        :pswitch_c
    .end packed-switch
.end method
