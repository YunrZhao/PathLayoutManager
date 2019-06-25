## 对 PathLayoutManager 的一点改进扩展

改进：
1. 把 `findClosestPosition` 找出离目标落点最近的Item索引对外公开
2. RecyclerView 添加 ScrollListener 监听滚动事件后，在 `onScrolled()` 中进行 查找离落点最近Item，实现监听滚动过程中Item变化

效果:

(图片有些大)

![](https://s19.aconvert.com/convert/p3r68-cdx67/7d2vt-xhhau.gif '效果')


原库地址：https://github.com/wuyr/PathLayoutManager
