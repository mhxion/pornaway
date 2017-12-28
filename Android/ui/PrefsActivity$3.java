.class Lorg/pornaway/ui/PrefsActivity$3;
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
    .line 140
    iput-object p1, p0, Lorg/pornaway/ui/PrefsActivity$3;->this$0:Lorg/pornaway/ui/PrefsActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onPreferenceChange(Landroid/preference/Preference;Ljava/lang/Object;)Z
    .registers 8
    .param p1, "preference"    # Landroid/preference/Preference;
    .param p2, "newValue"    # Ljava/lang/Object;

    .prologue
    const/4 v4, 0x1

    .line 145
    :try_start_1
    invoke-static {}, Lorg/sufficientlysecure/rootcommands/Shell;->startRootShell()Lorg/sufficientlysecure/rootcommands/Shell;

    move-result-object v1

    .line 147
    .local v1, "rootShell":Lorg/sufficientlysecure/rootcommands/Shell;
    const/4 v2, 0x1

    invoke-static {v2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    invoke-virtual {p2, v2}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_1d

    .line 149
    iget-object v2, p0, Lorg/pornaway/ui/PrefsActivity$3;->this$0:Lorg/pornaway/ui/PrefsActivity;

    # getter for: Lorg/pornaway/ui/PrefsActivity;->mActivity:Landroid/content/Context;
    invoke-static {v2}, Lorg/pornaway/ui/PrefsActivity;->access$000(Lorg/pornaway/ui/PrefsActivity;)Landroid/content/Context;

    move-result-object v2

    invoke-static {v2, v1}, Lorg/pornaway/util/WebserverUtils;->startWebserver(Landroid/content/Context;Lorg/sufficientlysecure/rootcommands/Shell;)V

    .line 155
    :goto_19
    invoke-virtual {v1}, Lorg/sufficientlysecure/rootcommands/Shell;->close()V

    .line 160
    .end local v1    # "rootShell":Lorg/sufficientlysecure/rootcommands/Shell;
    :goto_1c
    return v4

    .line 152
    .restart local v1    # "rootShell":Lorg/sufficientlysecure/rootcommands/Shell;
    :cond_1d
    iget-object v2, p0, Lorg/pornaway/ui/PrefsActivity$3;->this$0:Lorg/pornaway/ui/PrefsActivity;

    # getter for: Lorg/pornaway/ui/PrefsActivity;->mActivity:Landroid/content/Context;
    invoke-static {v2}, Lorg/pornaway/ui/PrefsActivity;->access$000(Lorg/pornaway/ui/PrefsActivity;)Landroid/content/Context;

    move-result-object v2

    invoke-static {v2, v1}, Lorg/pornaway/util/WebserverUtils;->stopWebserver(Landroid/content/Context;Lorg/sufficientlysecure/rootcommands/Shell;)V
    :try_end_26
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_26} :catch_27

    goto :goto_19

    .line 156
    .end local v1    # "rootShell":Lorg/sufficientlysecure/rootcommands/Shell;
    :catch_27
    move-exception v0

    .line 157
    .local v0, "e":Ljava/lang/Exception;
    const-string v2, "PornAway"

    const-string v3, "Problem while starting/stopping webserver!"

    invoke-static {v2, v3, v0}, Lorg/pornaway/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_1c
.end method
