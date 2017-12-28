.class Lorg/pornaway/ui/PrefsActivity$4;
.super Ljava/lang/Object;
.source "PrefsActivity.java"

# interfaces
.implements Landroid/preference/Preference$OnPreferenceChangeListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lorg/pornaway/ui/PrefsActivity;->onCreate(Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lorg/pornaway/ui/PrefsActivity;


# direct methods
.method constructor <init>(Lorg/pornaway/ui/PrefsActivity;)V
    .registers 2
    .param p1, "this$0"    # Lorg/pornaway/ui/PrefsActivity;

    .prologue
    .line 182
    iput-object p1, p0, Lorg/pornaway/ui/PrefsActivity$4;->this$0:Lorg/pornaway/ui/PrefsActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onPreferenceChange(Landroid/preference/Preference;Ljava/lang/Object;)Z
    .registers 6
    .param p1, "preference"    # Landroid/preference/Preference;
    .param p2, "newValue"    # Ljava/lang/Object;

    .prologue
    const/4 v2, 0x1

    .line 185
    const-string v0, "customTarget"

    invoke-virtual {p2, v0}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_13

    .line 186
    iget-object v0, p0, Lorg/pornaway/ui/PrefsActivity$4;->this$0:Lorg/pornaway/ui/PrefsActivity;

    # getter for: Lorg/pornaway/ui/PrefsActivity;->mCustomTarget:Landroid/preference/EditTextPreference;
    invoke-static {v0}, Lorg/pornaway/ui/PrefsActivity;->access$200(Lorg/pornaway/ui/PrefsActivity;)Landroid/preference/EditTextPreference;

    move-result-object v0

    invoke-virtual {v0, v2}, Landroid/preference/EditTextPreference;->setEnabled(Z)V

    .line 190
    :goto_12
    return v2

    .line 188
    :cond_13
    iget-object v0, p0, Lorg/pornaway/ui/PrefsActivity$4;->this$0:Lorg/pornaway/ui/PrefsActivity;

    # getter for: Lorg/pornaway/ui/PrefsActivity;->mCustomTarget:Landroid/preference/EditTextPreference;
    invoke-static {v0}, Lorg/pornaway/ui/PrefsActivity;->access$200(Lorg/pornaway/ui/PrefsActivity;)Landroid/preference/EditTextPreference;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/preference/EditTextPreference;->setEnabled(Z)V

    goto :goto_12
.end method
