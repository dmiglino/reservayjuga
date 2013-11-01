<div class="ace-settings-container" id="ace-settings-container">
	<div class="btn btn-app btn-xs btn-warning ace-settings-btn" id="ace-settings-btn">
		<i class="icon-cog bigger-150"></i>
	</div>

	<div class="ace-settings-box" id="ace-settings-box">
		<div>
			<div class="pull-left">
				<select id="skin-colorpicker" class="hide">
					<option data-skin="default" value="#438EB9">#438EB9</option>
					<option data-skin="skin-1" value="#222A2D">#222A2D</option>
					<option data-skin="skin-2" value="#C6487E">#C6487E</option>
					<option data-skin="skin-3" value="#D0D0D0">#D0D0D0</option>
				</select>
			</div>
			<span>&nbsp; <g:message code="settings.choose.skin.label" default="Choose Skin" /></span>
		</div>

		<div>
			<input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-navbar" />
			<label class="lbl" for="ace-settings-navbar"> <g:message code="settings.fixed.navbar.label" default="Fixed Navbar" /></label>
		</div>

		<div>
			<input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-sidebar" />
			<label class="lbl" for="ace-settings-sidebar"> <g:message code="settings.fixed.sidebar.label" default="Fixed Sidebar" /></label>
		</div>

		<div>
			<input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-breadcrumbs" />
			<label class="lbl" for="ace-settings-breadcrumbs"> <g:message code="settings.fixed.breadcrumbs.label" default="Fixed Breadcrumbs" /></label>
		</div>

		<div>
			<input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-rtl" />
			<label class="lbl" for="ace-settings-rtl"> <g:message code="settings.righttoleft.label" default="Right To Left" /> </label>
		</div>

		<div>
			<input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-add-container" />
			<label class="lbl" for="ace-settings-add-container">
				<g:message code="settings.inside.label" default="Inside" />
			</label>
		</div>
	</div>
</div><!-- /#ace-settings-container -->