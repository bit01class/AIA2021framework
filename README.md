## make framework

#### struts session
'''
ActionContext context = ActionContext.getContext();
                Map session = context.getSession();
                context.getSession().put("id", "admin");
'''
