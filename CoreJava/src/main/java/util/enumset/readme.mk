# EnumSet

## Que es?
EnumSet es una espcialización de Set que solo permite elementos Enum. Su firma es la siguiente:
```java
public abstract class EnumSet<E extends Enum<E>>
extends AbstractSet<E>
implements Cloneable, Serializable
```
Su principal ventaja es que trabaja con enum como cualquier colección, aportando operaciones como add o remove. Ademas tenemos la posibilidad de añadir diatónicamente enum.
EnumSet es representan internamente como vectores de bits. Esta representación es extremadamente compacta y eficiente. 