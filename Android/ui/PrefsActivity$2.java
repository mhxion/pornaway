.class Lorg/pornaway/ui/PrefsActivity$2;
.super Ljava/lang/Object;
.source "PrefsActivity.java"

# interfaces
.implements Landroid/preference/Preference$OnPreferenceClickListener;


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
    .line 124
    iput-object p1, p0, Lorg/pornaway/ui/PrefsActivity$2;->this$0:Lorg/pornaway/ui/PrefsActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onPreferenceClick(Landroid/preference/Preference;)Z
    .registers 5
    .param p1, "preference"    # Landroid/preference/Preference;

    .prologue
    const/4 v2, 0x0

    .line 128
    iget-object v0, p0, Lorg/pornaway/ui/PrefsActivity$2;->this$0:Lorg/pornaway/ui/PrefsActivity;

    # getter for: Lorg/pornaway/ui/PrefsActivity;->mActivity:Landroid/content/Context;
    invoke-static {v0}, Lorg/pornaway/ui/PrefsActivity;->access$000(Lorg/pornaway/ui/PrefsActivity;)Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lorg/pornaway/helper/PreferenceHelper;->getUpdateCheckDaily(Landroid/content/Context;)Z

    move-result v0

    if-eqz v0, :cond_1c

    .line 129
    new-instance v0, Lorg/pornaway/service/DailyListener;

    invoke-direct {v0}, Lorg/pornaway/service/DailyListener;-><init>()V

    iget-object v1, p0, Lorg/pornaway/ui/PrefsActivity$2;->this$0:Lorg/pornaway/ui/PrefsActivity;

    # getter for: Lorg/pornaway/ui/PrefsActivity;->mActivity:Landroid/content/Context;
    invoke-static {v1}, Lorg/pornaway/ui/PrefsActivity;->access$000(Lorg/pornaway/ui/PrefsActivity;)Landroid/content/Context;

    move-result-object v1

    invoke-static {v0, v1, v2}, Lcom/commonsware/cwac/wakeful/WakefulIntentService;->scheduleAlarms(Lcom/commonsware/cwac/wakeful/WakefulIntentService$AlarmListener;Landroid/content/Context;Z)V

    .line 133
    :goto_1b
    return v2

    .line 131
    :cond_1c
    iget-object v0, p0, Lorg/pornaway/ui/PrefsActivity$2;->this$0:Lorg/pornaway/ui/PrefsActivity;

    # getter for: Lorg/pornaway/ui/PrefsActivity;->mActivity:Landroid/content/Context;
    invoke-static {v0}, Lorg/pornaway/ui/PrefsActivity;->access$000(Lorg/pornaway/ui/PrefsActivity;)Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcom/commonsware/cwac/wakeful/WakefulIntentService;->cancelAlarms(Landroid/content/Context;)V

    goto :goto_1b
.end method
