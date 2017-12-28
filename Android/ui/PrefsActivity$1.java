.class Lorg/pornaway/ui/PrefsActivity$1;
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
    .line 94
    iput-object p1, p0, Lorg/pornaway/ui/PrefsActivity$1;->this$0:Lorg/pornaway/ui/PrefsActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onPreferenceChange(Landroid/preference/Preference;Ljava/lang/Object;)Z
    .registers 9
    .param p1, "preference"    # Landroid/preference/Preference;
    .param p2, "newValue"    # Ljava/lang/Object;

    .prologue
    .line 98
    :try_start_0
    invoke-static {}, Lorg/sufficientlysecure/rootcommands/Shell;->startRootShell()Lorg/sufficientlysecure/rootcommands/Shell;

    move-result-object v1

    .line 100
    .local v1, "rootShell":Lorg/sufficientlysecure/rootcommands/Shell;
    const/4 v3, 0x1

    invoke-static {v3}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v3

    invoke-virtual {p2, v3}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_19

    .line 101
    iget-object v3, p0, Lorg/pornaway/ui/PrefsActivity$1;->this$0:Lorg/pornaway/ui/PrefsActivity;

    invoke-static {v3, v1}, Lorg/pornaway/util/SystemlessUtils;->enableSystemlessMode(Landroid/content/Context;Lorg/sufficientlysecure/rootcommands/Shell;)Z

    move-result v2

    .line 109
    .local v2, "successful":Z
    :cond_15
    :goto_15
    invoke-virtual {v1}, Lorg/sufficientlysecure/rootcommands/Shell;->close()V

    .line 113
    .end local v1    # "rootShell":Lorg/sufficientlysecure/rootcommands/Shell;
    .end local v2    # "successful":Z
    :goto_18
    return v2

    .line 103
    .restart local v1    # "rootShell":Lorg/sufficientlysecure/rootcommands/Shell;
    :cond_19
    invoke-static {v1}, Lorg/pornaway/util/SystemlessUtils;->disableSystemlessMode(Lorg/sufficientlysecure/rootcommands/Shell;)Z

    move-result v2

    .line 104
    .restart local v2    # "successful":Z
    if-eqz v2, :cond_15

    .line 105
    iget-object v3, p0, Lorg/pornaway/ui/PrefsActivity$1;->this$0:Lorg/pornaway/ui/PrefsActivity;

    const v4, 0x7f0800b4

    const v5, 0x7f0800b3

    invoke-static {v3, v4, v5}, Lorg/pornaway/util/Utils;->rebootQuestion(Landroid/content/Context;II)V
    :try_end_2a
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_2a} :catch_2b

    goto :goto_15

    .line 111
    .end local v1    # "rootShell":Lorg/sufficientlysecure/rootcommands/Shell;
    .end local v2    # "successful":Z
    :catch_2b
    move-exception v0

    .line 112
    .local v0, "exception":Ljava/lang/Exception;
    const-string v3, "PornAway"

    const-string v4, "Problem while installing/removing systemless script."

    invoke-static {v3, v4, v0}, Lorg/pornaway/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 113
    const/4 v2, 0x0

    goto :goto_18
.end method
