<%--
  Created by IntelliJ IDEA.
  User: Joe
  Date: 2019/7/12
  Time: 10:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
</div>
</div>
<!-- /page content -->

<!-- footer content -->
<footer>
    <div class="pull-right">
        Gentelella - Bootstrap Admin Template by <a href="https://colorlib.com">Colorlib</a>
    </div>
    <div class="clearfix"></div>
</footer>
<!-- /footer content -->
</div>
</div>

<!-- jQuery -->
<script src="${pageContext.request.contextPath}/statics/js/jquery.min.js"></script>
<!-- jquery-extend -->
<script src="${pageContext.request.contextPath}/statics/js/jquery-extends.js"></script>
<!-- Bootstrap -->
<script src="${pageContext.request.contextPath}/statics/js/bootstrap.min.js"></script>
<!-- ICheck -->
<script src="${pageContext.request.contextPath}/statics/js/icheck.min.js"></script>
<!-- FastClick -->
<script src="${pageContext.request.contextPath}/statics/js/fastclick.js"></script>
<!-- NProgress -->
<script src="${pageContext.request.contextPath}/statics/js/nprogress.js"></script>
<!-- Custom Theme Scripts -->
<script src="${pageContext.request.contextPath}/statics/js/custom.min.js"></script>
<c:if test="${param.needTable}">
    <!-- Bootstrap Table -->
    <script src="${pageContext.request.contextPath}/statics/js/bootstrap-table.min.js"></script>
    <script src="${pageContext.request.contextPath}/statics/js/locale/bootstrap-table-zh-CN.js"></script>
</c:if>
<c:if test="${param.needSwitch}">
    <!-- Bootstrap Switch -->
    <script src="${pageContext.request.contextPath}/statics/js/bootstrap-switch.min.js"></script>
</c:if>
</body>
</html>
