.class Lorg/pornaway/ui/PrefsActivity$SystemlessCheckTask;
.super Landroid/os/AsyncTask;
.source "PrefsActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/pornaway/ui/PrefsActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "SystemlessCheckTask"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/os/AsyncTask",
        "<",
        "Ljava/lang/Void;",
        "Ljava/lang/Void;",
        "Lorg/pornaway/util/SystemlessUtils$SystemlessModeStatus;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lorg/pornaway/ui/PrefsActivity;


# direct methods
.method private constructor <init>(Lorg/pornaway/ui/PrefsActivity;)V
    .registers 2

    .prologue
    .line 222
    iput-object p1, p0, Lorg/pornaway/ui/PrefsActivity$SystemlessCheckTask;->this$0:Lorg/pornaway/ui/PrefsActivity;

    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lorg/pornaway/ui/PrefsActivity;Lorg/pornaway/ui/PrefsActivity$1;)V
    .registers 3
    .param p1, "x0"    # Lorg/pornaway/ui/PrefsActivity;
    .param p2, "x1"    # Lorg/pornaway/ui/PrefsActivity$1;

    .prologue
    .line 222
    invoke-direct {p0, p1}, Lorg/pornaway/ui/PrefsActivity$SystemlessCheckTask;-><init>(Lorg/pornaway/ui/PrefsActivity;)V

    return-void
.end method


# virtual methods
.method protected bridge synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .registers 3

    .prologue
    .line 222
    check-cast p1, [Ljava/lang/Void;

    invoke-virtual {p0, p1}, Lorg/pornaway/ui/PrefsActivity$SystemlessCheckTask;->doInBackground([Ljava/lang/Void;)Lorg/pornaway/util/SystemlessUtils$SystemlessModeStatus;

    move-result-object v0

    return-object v0
.end method

.method protected varargs doInBackground([Ljava/lang/Void;)Lorg/pornaway/util/SystemlessUtils$SystemlessModeStatus;
    .registers 8
    .param p1, "params"    # [Ljava/lang/Void;

    .prologue
    .line 226
    const/4 v3, 0x0

    .line 227
    .local v3, "supported":Z
    const/4 v0, 0x0

    .line 230
    .local v0, "enabled":Z
    :try_start_2
    invoke-static {}, Lorg/sufficientlysecure/rootcommands/Shell;->startRootShell()Lorg/sufficientlysecure/rootcommands/Shell;

    move-result-object v2

    .line 231
    .local v2, "rootShell":Lorg/sufficientlysecure/rootcommands/Shell;
    invoke-static {v2}, Lorg/pornaway/util/SystemlessUtils;->isSystemlessModeSupported(Lorg/sufficientlysecure/rootcommands/Shell;)Z

    move-result v3

    .line 232
    invoke-static {v2}, Lorg/pornaway/util/SystemlessUtils;->isSystemlessModeEnabled(Lorg/sufficientlysecure/rootcommands/Shell;)Z

    move-result v0

    .line 233
    invoke-virtual {v2}, Lorg/sufficientlysecure/rootcommands/Shell;->close()V
    :try_end_11
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_11} :catch_17

    .line 238
    .end local v2    # "rootShell":Lorg/sufficientlysecure/rootcommands/Shell;
    :goto_11
    new-instance v4, Lorg/pornaway/util/SystemlessUtils$SystemlessModeStatus;

    invoke-direct {v4, v3, v0}, Lorg/pornaway/util/SystemlessUtils$SystemlessModeStatus;-><init>(ZZ)V

    return-object v4

    .line 234
    :catch_17
    move-exception v1

    .line 235
    .local v1, "exception":Ljava/lang/Exception;
    const-string v4, "PornAway"

    const-string v5, "Problem while checking systemless mode."

    invoke-static {v4, v5, v1}, Lorg/pornaway/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_11
.end method

.method protected bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .registers 2

    .prologue
    .line 222
    check-cast p1, Lorg/pornaway/util/SystemlessUtils$SystemlessModeStatus;

    invoke-virtual {p0, p1}, Lorg/pornaway/ui/PrefsActivity$SystemlessCheckTask;->onPostExecute(Lorg/pornaway/util/SystemlessUtils$SystemlessModeStatus;)V

    return-void
.end method

.method protected onPostExecute(Lorg/pornaway/util/SystemlessUtils$SystemlessModeStatus;)V
    .registers 4
    .param p1, "status"    # Lorg/pornaway/util/SystemlessUtils$SystemlessModeStatus;

    .prologue
    .line 244
    iget-object v0, p0, Lorg/pornaway/ui/PrefsActivity$SystemlessCheckTask;->this$0:Lorg/pornaway/ui/PrefsActivity;

    # getter for: Lorg/pornaway/ui/PrefsActivity;->mSystemless:Landroid/preference/CheckBoxPreference;
    invoke-static {v0}, Lorg/pornaway/ui/PrefsActivity;->access$300(Lorg/pornaway/ui/PrefsActivity;)Landroid/preference/CheckBoxPreference;

    move-result-object v0

    if-nez v0, :cond_9

    .line 250
    :goto_8
    return-void

    .line 248
    :cond_9
    iget-object v0, p0, Lorg/pornaway/ui/PrefsActivity$SystemlessCheckTask;->this$0:Lorg/pornaway/ui/PrefsActivity;

    # getter for: Lorg/pornaway/ui/PrefsActivity;->mSystemless:Landroid/preference/CheckBoxPreference;
    invoke-static {v0}, Lorg/pornaway/ui/PrefsActivity;->access$300(Lorg/pornaway/ui/PrefsActivity;)Landroid/preference/CheckBoxPreference;

    move-result-object v0

    invoke-virtual {p1}, Lorg/pornaway/util/SystemlessUtils$SystemlessModeStatus;->isSupported()Z

    move-result v1

    invoke-virtual {v0, v1}, Landroid/preference/CheckBoxPreference;->setEnabled(Z)V

    .line 249
    iget-object v0, p0, Lorg/pornaway/ui/PrefsActivity$SystemlessCheckTask;->this$0:Lorg/pornaway/ui/PrefsActivity;

    # getter for: Lorg/pornaway/ui/PrefsActivity;->mSystemless:Landroid/preference/CheckBoxPreference;
    invoke-static {v0}, Lorg/pornaway/ui/PrefsActivity;->access$300(Lorg/pornaway/ui/PrefsActivity;)Landroid/preference/CheckBoxPreference;

    move-result-object v0

    invoke-virtual {p1}, Lorg/pornaway/util/SystemlessUtils$SystemlessModeStatus;->isEnabled()Z

    move-result v1

    invoke-virtual {v0, v1}, Landroid/preference/CheckBoxPreference;->setChecked(Z)V

    goto :goto_8
.end method
