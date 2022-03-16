# Beans Autowiring/Beans Collaboration:

In general, in spring applications, if we want to inject dependent values in setter
method dependency injection or in constructor dependency injection we have to use
<property> or <constructor-arg> tags under <bean> tag. If we want to inject simple
values like primitive values, string values then we have to use "value" attribute and if
we want to inject Secondary data type elements like Objects then we have to use "ref"
attribute or we have to use <ref> tag in beans configuration file.  
  
In spring applicatins , if we want to inject dependent bean objects to another bean
object automatically with out providing <property> tags and <constructor-arg> tags
then we have to use "Autowiring" feature.  
  
"Autowiring" feature of spring framework will make the IOC Container to inject
dependent objects to the bean objects automatically on the basis of the properties
names or on the basis of properties types with out checking <property> tags and
<constructor-arg> tags.  
  
There are four ways to manage autowiring in Spring applications.  
  
1.XML Based Autowiring
2.Annotation Based Autowiring
3.Auto-Discovery[Stereo Types]
4.Java Based Autowiring
