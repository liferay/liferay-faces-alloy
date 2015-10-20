/**
 * Copyright (c) 2000-2015 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
package com.liferay.faces.alloy.component.media;
//J-

import javax.annotation.Generated;
import javax.faces.component.UIComponentBase;


/**
 * @author	Bruno Basto
 * @author	Kyle Stiemann
 */
@Generated(value = "com.liferay.alloy.tools.builder.FacesBuilder")
public abstract class MediaBase extends UIComponentBase {

	// Public Constants
	public static final String COMPONENT_FAMILY = "com.liferay.faces.alloy.component.media";
	public static final String COMPONENT_TYPE = "com.liferay.faces.alloy.component.media.Media";
	public static final String RENDERER_TYPE = "com.liferay.faces.alloy.component.media.MediaRenderer";

	// Protected Enumerations
	protected enum MediaPropertyKeys {
		autoplay,
		contentType,
		controls,
		degrade,
		flashPlayer,
		flashPlayerVersion,
		library,
		loop,
		muted,
		name,
		onabort,
		onblur,
		oncanplay,
		oncanplaythrough,
		onclick,
		ondblclick,
		ondurationchange,
		onemptied,
		onended,
		onerror,
		onfocus,
		onkeydown,
		onkeypress,
		onkeyup,
		onloadeddata,
		onloadedmetadata,
		onloadstart,
		onmousedown,
		onmousemove,
		onmouseout,
		onmouseover,
		onmouseup,
		onpause,
		onplay,
		onplaying,
		onprogress,
		onratechange,
		onseeked,
		onseeking,
		onstalled,
		onsuspend,
		ontimeupdate,
		onvolumechange,
		onwaiting,
		preload,
		style,
		value
	}

	public MediaBase() {
		super();
		setRendererType(RENDERER_TYPE);
	}

	@Override
	public String getFamily() {
		return COMPONENT_FAMILY;
	}

	/**
	 * <code>autoplay</code> attribute description:
	 * <br /><br />
	 * HTML5 passthrough attribute specifying whether the media will begin playing automatically.
	 */
	public boolean isAutoplay() {
		return (Boolean) getStateHelper().eval(MediaPropertyKeys.autoplay, false);
	}

	/**
	 * <code>autoplay</code> attribute description:
	 * <br /><br />
	 * HTML5 passthrough attribute specifying whether the media will begin playing automatically.
	 */
	public void setAutoplay(boolean autoplay) {
		getStateHelper().put(MediaPropertyKeys.autoplay, autoplay);
	}

	/**
	 * <code>contentType</code> attribute description:
	 * <br /><br />
	 * The content type of the media. This attribute is required when the <code>value</code> attribute is used to specify the media URL. Otherwise, the contentType defaults to to the content type determined by the JSF runtime for the resource.
	 */
	public String getContentType() {
		return (String) getStateHelper().eval(MediaPropertyKeys.contentType, null);
	}

	/**
	 * <code>contentType</code> attribute description:
	 * <br /><br />
	 * The content type of the media. This attribute is required when the <code>value</code> attribute is used to specify the media URL. Otherwise, the contentType defaults to to the content type determined by the JSF runtime for the resource.
	 */
	public void setContentType(String contentType) {
		getStateHelper().put(MediaPropertyKeys.contentType, contentType);
	}

	/**
	 * <code>controls</code> attribute description:
	 * <br /><br />
	 * HTML5 passthrough attribute specifying whether controls should be rendered for the media.
	 */
	public boolean isControls() {
		return (Boolean) getStateHelper().eval(MediaPropertyKeys.controls, false);
	}

	/**
	 * <code>controls</code> attribute description:
	 * <br /><br />
	 * HTML5 passthrough attribute specifying whether controls should be rendered for the media.
	 */
	public void setControls(boolean controls) {
		getStateHelper().put(MediaPropertyKeys.controls, controls);
	}

	/**
	 * <code>degrade</code> attribute description:
	 * <br /><br />
	 * When true the component will gracefully degrade to the Adobe&reg; Flash&reg; player for older browsers.
	 */
	public boolean isDegrade() {
		return (Boolean) getStateHelper().eval(MediaPropertyKeys.degrade, true);
	}

	/**
	 * <code>degrade</code> attribute description:
	 * <br /><br />
	 * When true the component will gracefully degrade to the Adobe&reg; Flash&reg; player for older browsers.
	 */
	public void setDegrade(boolean degrade) {
		getStateHelper().put(MediaPropertyKeys.degrade, degrade);
	}

	/**
	 * <code>flashPlayer</code> attribute description:
	 * <br /><br />
	 * A context-relative path, resource URL, or FacesResource that can be used to retrieve the Adobe&reg; Flash&reg; player. The default flash player is the flash player bundled with AlloyUI. <strong>Note:</strong> The AlloyUI player does not support <code>.ogv</code> or <code>.webm</code> formats.
	 */
	public Object getFlashPlayer() {
		return (Object) getStateHelper().eval(MediaPropertyKeys.flashPlayer, null);
	}

	/**
	 * <code>flashPlayer</code> attribute description:
	 * <br /><br />
	 * A context-relative path, resource URL, or FacesResource that can be used to retrieve the Adobe&reg; Flash&reg; player. The default flash player is the flash player bundled with AlloyUI. <strong>Note:</strong> The AlloyUI player does not support <code>.ogv</code> or <code>.webm</code> formats.
	 */
	public void setFlashPlayer(Object flashPlayer) {
		getStateHelper().put(MediaPropertyKeys.flashPlayer, flashPlayer);
	}

	/**
	 * <code>flashPlayerVersion</code> attribute description:
	 * <br /><br />
	 * The version of Adobe&reg; Flash&reg; required to play this media.
	 */
	public String getFlashPlayerVersion() {
		return (String) getStateHelper().eval(MediaPropertyKeys.flashPlayerVersion, "9,0,0,0");
	}

	/**
	 * <code>flashPlayerVersion</code> attribute description:
	 * <br /><br />
	 * The version of Adobe&reg; Flash&reg; required to play this media.
	 */
	public void setFlashPlayerVersion(String flashPlayerVersion) {
		getStateHelper().put(MediaPropertyKeys.flashPlayerVersion, flashPlayerVersion);
	}

	/**
	 * <code>library</code> attribute description:
	 * <br /><br />
	 * The name of the library which contains the resource.
	 */
	public String getLibrary() {
		return (String) getStateHelper().eval(MediaPropertyKeys.library, null);
	}

	/**
	 * <code>library</code> attribute description:
	 * <br /><br />
	 * The name of the library which contains the resource.
	 */
	public void setLibrary(String library) {
		getStateHelper().put(MediaPropertyKeys.library, library);
	}

	/**
	 * <code>loop</code> attribute description:
	 * <br /><br />
	 * HTML5 passthrough attribute specifying whether the media will restart after it has completed playing.
	 */
	public boolean isLoop() {
		return (Boolean) getStateHelper().eval(MediaPropertyKeys.loop, false);
	}

	/**
	 * <code>loop</code> attribute description:
	 * <br /><br />
	 * HTML5 passthrough attribute specifying whether the media will restart after it has completed playing.
	 */
	public void setLoop(boolean loop) {
		getStateHelper().put(MediaPropertyKeys.loop, loop);
	}

	/**
	 * <code>muted</code> attribute description:
	 * <br /><br />
	 * HTML5 passthrough attribute specifying whether the media will be muted initially.
	 */
	public boolean isMuted() {
		return (Boolean) getStateHelper().eval(MediaPropertyKeys.muted, false);
	}

	/**
	 * <code>muted</code> attribute description:
	 * <br /><br />
	 * HTML5 passthrough attribute specifying whether the media will be muted initially.
	 */
	public void setMuted(boolean muted) {
		getStateHelper().put(MediaPropertyKeys.muted, muted);
	}

	/**
	 * <code>name</code> attribute description:
	 * <br /><br />
	 * The name of the resource file to be included on the page.
	 */
	public String getName() {
		return (String) getStateHelper().eval(MediaPropertyKeys.name, null);
	}

	/**
	 * <code>name</code> attribute description:
	 * <br /><br />
	 * The name of the resource file to be included on the page.
	 */
	public void setName(String name) {
		getStateHelper().put(MediaPropertyKeys.name, name);
	}

	/**
	 * <code>onabort</code> attribute description:
	 * <br /><br />
	 * Javascript to execute when a abort event occurs.
	 */
	public String getOnabort() {
		return (String) getStateHelper().eval(MediaPropertyKeys.onabort, null);
	}

	/**
	 * <code>onabort</code> attribute description:
	 * <br /><br />
	 * Javascript to execute when a abort event occurs.
	 */
	public void setOnabort(String onabort) {
		getStateHelper().put(MediaPropertyKeys.onabort, onabort);
	}

	/**
	 * <code>onblur</code> attribute description:
	 * <br /><br />
	 * Javascript to execute after this component loses focus.
	 */
	public String getOnblur() {
		return (String) getStateHelper().eval(MediaPropertyKeys.onblur, null);
	}

	/**
	 * <code>onblur</code> attribute description:
	 * <br /><br />
	 * Javascript to execute after this component loses focus.
	 */
	public void setOnblur(String onblur) {
		getStateHelper().put(MediaPropertyKeys.onblur, onblur);
	}

	/**
	 * <code>oncanplay</code> attribute description:
	 * <br /><br />
	 * Javascript to execute when a canplay event occurs.
	 */
	public String getOncanplay() {
		return (String) getStateHelper().eval(MediaPropertyKeys.oncanplay, null);
	}

	/**
	 * <code>oncanplay</code> attribute description:
	 * <br /><br />
	 * Javascript to execute when a canplay event occurs.
	 */
	public void setOncanplay(String oncanplay) {
		getStateHelper().put(MediaPropertyKeys.oncanplay, oncanplay);
	}

	/**
	 * <code>oncanplaythrough</code> attribute description:
	 * <br /><br />
	 * Javascript to execute when a canplaythrough event occurs.
	 */
	public String getOncanplaythrough() {
		return (String) getStateHelper().eval(MediaPropertyKeys.oncanplaythrough, null);
	}

	/**
	 * <code>oncanplaythrough</code> attribute description:
	 * <br /><br />
	 * Javascript to execute when a canplaythrough event occurs.
	 */
	public void setOncanplaythrough(String oncanplaythrough) {
		getStateHelper().put(MediaPropertyKeys.oncanplaythrough, oncanplaythrough);
	}

	/**
	 * <code>onclick</code> attribute description:
	 * <br /><br />
	 * Javascript to execute when this component is clicked.
	 */
	public String getOnclick() {
		return (String) getStateHelper().eval(MediaPropertyKeys.onclick, null);
	}

	/**
	 * <code>onclick</code> attribute description:
	 * <br /><br />
	 * Javascript to execute when this component is clicked.
	 */
	public void setOnclick(String onclick) {
		getStateHelper().put(MediaPropertyKeys.onclick, onclick);
	}

	/**
	 * <code>ondblclick</code> attribute description:
	 * <br /><br />
	 * Javascript to execute when a double click event occurs.
	 */
	public String getOndblclick() {
		return (String) getStateHelper().eval(MediaPropertyKeys.ondblclick, null);
	}

	/**
	 * <code>ondblclick</code> attribute description:
	 * <br /><br />
	 * Javascript to execute when a double click event occurs.
	 */
	public void setOndblclick(String ondblclick) {
		getStateHelper().put(MediaPropertyKeys.ondblclick, ondblclick);
	}

	/**
	 * <code>ondurationchange</code> attribute description:
	 * <br /><br />
	 * Javascript to execute when a durationchange event occurs.
	 */
	public String getOndurationchange() {
		return (String) getStateHelper().eval(MediaPropertyKeys.ondurationchange, null);
	}

	/**
	 * <code>ondurationchange</code> attribute description:
	 * <br /><br />
	 * Javascript to execute when a durationchange event occurs.
	 */
	public void setOndurationchange(String ondurationchange) {
		getStateHelper().put(MediaPropertyKeys.ondurationchange, ondurationchange);
	}

	/**
	 * <code>onemptied</code> attribute description:
	 * <br /><br />
	 * Javascript to execute when a emptied event occurs.
	 */
	public String getOnemptied() {
		return (String) getStateHelper().eval(MediaPropertyKeys.onemptied, null);
	}

	/**
	 * <code>onemptied</code> attribute description:
	 * <br /><br />
	 * Javascript to execute when a emptied event occurs.
	 */
	public void setOnemptied(String onemptied) {
		getStateHelper().put(MediaPropertyKeys.onemptied, onemptied);
	}

	/**
	 * <code>onended</code> attribute description:
	 * <br /><br />
	 * Javascript to execute when a ended event occurs.
	 */
	public String getOnended() {
		return (String) getStateHelper().eval(MediaPropertyKeys.onended, null);
	}

	/**
	 * <code>onended</code> attribute description:
	 * <br /><br />
	 * Javascript to execute when a ended event occurs.
	 */
	public void setOnended(String onended) {
		getStateHelper().put(MediaPropertyKeys.onended, onended);
	}

	/**
	 * <code>onerror</code> attribute description:
	 * <br /><br />
	 * Javascript to execute when a error event occurs.
	 */
	public String getOnerror() {
		return (String) getStateHelper().eval(MediaPropertyKeys.onerror, null);
	}

	/**
	 * <code>onerror</code> attribute description:
	 * <br /><br />
	 * Javascript to execute when a error event occurs.
	 */
	public void setOnerror(String onerror) {
		getStateHelper().put(MediaPropertyKeys.onerror, onerror);
	}

	/**
	 * <code>onfocus</code> attribute description:
	 * <br /><br />
	 * Javascript to execute when this component gets focus.
	 */
	public String getOnfocus() {
		return (String) getStateHelper().eval(MediaPropertyKeys.onfocus, null);
	}

	/**
	 * <code>onfocus</code> attribute description:
	 * <br /><br />
	 * Javascript to execute when this component gets focus.
	 */
	public void setOnfocus(String onfocus) {
		getStateHelper().put(MediaPropertyKeys.onfocus, onfocus);
	}

	/**
	 * <code>onkeydown</code> attribute description:
	 * <br /><br />
	 * Javascript to execute when a keydown event occurs.
	 */
	public String getOnkeydown() {
		return (String) getStateHelper().eval(MediaPropertyKeys.onkeydown, null);
	}

	/**
	 * <code>onkeydown</code> attribute description:
	 * <br /><br />
	 * Javascript to execute when a keydown event occurs.
	 */
	public void setOnkeydown(String onkeydown) {
		getStateHelper().put(MediaPropertyKeys.onkeydown, onkeydown);
	}

	/**
	 * <code>onkeypress</code> attribute description:
	 * <br /><br />
	 * Javascript to execute when a keypress event occurs.
	 */
	public String getOnkeypress() {
		return (String) getStateHelper().eval(MediaPropertyKeys.onkeypress, null);
	}

	/**
	 * <code>onkeypress</code> attribute description:
	 * <br /><br />
	 * Javascript to execute when a keypress event occurs.
	 */
	public void setOnkeypress(String onkeypress) {
		getStateHelper().put(MediaPropertyKeys.onkeypress, onkeypress);
	}

	/**
	 * <code>onkeyup</code> attribute description:
	 * <br /><br />
	 * Javascript to execute when a keyup event occurs.
	 */
	public String getOnkeyup() {
		return (String) getStateHelper().eval(MediaPropertyKeys.onkeyup, null);
	}

	/**
	 * <code>onkeyup</code> attribute description:
	 * <br /><br />
	 * Javascript to execute when a keyup event occurs.
	 */
	public void setOnkeyup(String onkeyup) {
		getStateHelper().put(MediaPropertyKeys.onkeyup, onkeyup);
	}

	/**
	 * <code>onloadeddata</code> attribute description:
	 * <br /><br />
	 * Javascript to execute when a loadeddata event occurs.
	 */
	public String getOnloadeddata() {
		return (String) getStateHelper().eval(MediaPropertyKeys.onloadeddata, null);
	}

	/**
	 * <code>onloadeddata</code> attribute description:
	 * <br /><br />
	 * Javascript to execute when a loadeddata event occurs.
	 */
	public void setOnloadeddata(String onloadeddata) {
		getStateHelper().put(MediaPropertyKeys.onloadeddata, onloadeddata);
	}

	/**
	 * <code>onloadedmetadata</code> attribute description:
	 * <br /><br />
	 * Javascript to execute when a loadedmetadata event occurs.
	 */
	public String getOnloadedmetadata() {
		return (String) getStateHelper().eval(MediaPropertyKeys.onloadedmetadata, null);
	}

	/**
	 * <code>onloadedmetadata</code> attribute description:
	 * <br /><br />
	 * Javascript to execute when a loadedmetadata event occurs.
	 */
	public void setOnloadedmetadata(String onloadedmetadata) {
		getStateHelper().put(MediaPropertyKeys.onloadedmetadata, onloadedmetadata);
	}

	/**
	 * <code>onloadstart</code> attribute description:
	 * <br /><br />
	 * Javascript to execute when a loadstart event occurs.
	 */
	public String getOnloadstart() {
		return (String) getStateHelper().eval(MediaPropertyKeys.onloadstart, null);
	}

	/**
	 * <code>onloadstart</code> attribute description:
	 * <br /><br />
	 * Javascript to execute when a loadstart event occurs.
	 */
	public void setOnloadstart(String onloadstart) {
		getStateHelper().put(MediaPropertyKeys.onloadstart, onloadstart);
	}

	/**
	 * <code>onmousedown</code> attribute description:
	 * <br /><br />
	 * Javascript to execute when a mousedown event occurs.
	 */
	public String getOnmousedown() {
		return (String) getStateHelper().eval(MediaPropertyKeys.onmousedown, null);
	}

	/**
	 * <code>onmousedown</code> attribute description:
	 * <br /><br />
	 * Javascript to execute when a mousedown event occurs.
	 */
	public void setOnmousedown(String onmousedown) {
		getStateHelper().put(MediaPropertyKeys.onmousedown, onmousedown);
	}

	/**
	 * <code>onmousemove</code> attribute description:
	 * <br /><br />
	 * Javascript to execute when a mousemove event occurs.
	 */
	public String getOnmousemove() {
		return (String) getStateHelper().eval(MediaPropertyKeys.onmousemove, null);
	}

	/**
	 * <code>onmousemove</code> attribute description:
	 * <br /><br />
	 * Javascript to execute when a mousemove event occurs.
	 */
	public void setOnmousemove(String onmousemove) {
		getStateHelper().put(MediaPropertyKeys.onmousemove, onmousemove);
	}

	/**
	 * <code>onmouseout</code> attribute description:
	 * <br /><br />
	 * Javascript to execute when a mouseout event occurs.
	 */
	public String getOnmouseout() {
		return (String) getStateHelper().eval(MediaPropertyKeys.onmouseout, null);
	}

	/**
	 * <code>onmouseout</code> attribute description:
	 * <br /><br />
	 * Javascript to execute when a mouseout event occurs.
	 */
	public void setOnmouseout(String onmouseout) {
		getStateHelper().put(MediaPropertyKeys.onmouseout, onmouseout);
	}

	/**
	 * <code>onmouseover</code> attribute description:
	 * <br /><br />
	 * Javascript to execute when a mouseover event occurs.
	 */
	public String getOnmouseover() {
		return (String) getStateHelper().eval(MediaPropertyKeys.onmouseover, null);
	}

	/**
	 * <code>onmouseover</code> attribute description:
	 * <br /><br />
	 * Javascript to execute when a mouseover event occurs.
	 */
	public void setOnmouseover(String onmouseover) {
		getStateHelper().put(MediaPropertyKeys.onmouseover, onmouseover);
	}

	/**
	 * <code>onmouseup</code> attribute description:
	 * <br /><br />
	 * Javascript to execute when a mouseup event occurs.
	 */
	public String getOnmouseup() {
		return (String) getStateHelper().eval(MediaPropertyKeys.onmouseup, null);
	}

	/**
	 * <code>onmouseup</code> attribute description:
	 * <br /><br />
	 * Javascript to execute when a mouseup event occurs.
	 */
	public void setOnmouseup(String onmouseup) {
		getStateHelper().put(MediaPropertyKeys.onmouseup, onmouseup);
	}

	/**
	 * <code>onpause</code> attribute description:
	 * <br /><br />
	 * Javascript to execute when a pause event occurs.
	 */
	public String getOnpause() {
		return (String) getStateHelper().eval(MediaPropertyKeys.onpause, null);
	}

	/**
	 * <code>onpause</code> attribute description:
	 * <br /><br />
	 * Javascript to execute when a pause event occurs.
	 */
	public void setOnpause(String onpause) {
		getStateHelper().put(MediaPropertyKeys.onpause, onpause);
	}

	/**
	 * <code>onplay</code> attribute description:
	 * <br /><br />
	 * Javascript to execute when a play event occurs.
	 */
	public String getOnplay() {
		return (String) getStateHelper().eval(MediaPropertyKeys.onplay, null);
	}

	/**
	 * <code>onplay</code> attribute description:
	 * <br /><br />
	 * Javascript to execute when a play event occurs.
	 */
	public void setOnplay(String onplay) {
		getStateHelper().put(MediaPropertyKeys.onplay, onplay);
	}

	/**
	 * <code>onplaying</code> attribute description:
	 * <br /><br />
	 * Javascript to execute when a playing event occurs.
	 */
	public String getOnplaying() {
		return (String) getStateHelper().eval(MediaPropertyKeys.onplaying, null);
	}

	/**
	 * <code>onplaying</code> attribute description:
	 * <br /><br />
	 * Javascript to execute when a playing event occurs.
	 */
	public void setOnplaying(String onplaying) {
		getStateHelper().put(MediaPropertyKeys.onplaying, onplaying);
	}

	/**
	 * <code>onprogress</code> attribute description:
	 * <br /><br />
	 * Javascript to execute when a progress event occurs.
	 */
	public String getOnprogress() {
		return (String) getStateHelper().eval(MediaPropertyKeys.onprogress, null);
	}

	/**
	 * <code>onprogress</code> attribute description:
	 * <br /><br />
	 * Javascript to execute when a progress event occurs.
	 */
	public void setOnprogress(String onprogress) {
		getStateHelper().put(MediaPropertyKeys.onprogress, onprogress);
	}

	/**
	 * <code>onratechange</code> attribute description:
	 * <br /><br />
	 * Javascript to execute when a ratechange event occurs.
	 */
	public String getOnratechange() {
		return (String) getStateHelper().eval(MediaPropertyKeys.onratechange, null);
	}

	/**
	 * <code>onratechange</code> attribute description:
	 * <br /><br />
	 * Javascript to execute when a ratechange event occurs.
	 */
	public void setOnratechange(String onratechange) {
		getStateHelper().put(MediaPropertyKeys.onratechange, onratechange);
	}

	/**
	 * <code>onseeked</code> attribute description:
	 * <br /><br />
	 * Javascript to execute when a seeked event occurs.
	 */
	public String getOnseeked() {
		return (String) getStateHelper().eval(MediaPropertyKeys.onseeked, null);
	}

	/**
	 * <code>onseeked</code> attribute description:
	 * <br /><br />
	 * Javascript to execute when a seeked event occurs.
	 */
	public void setOnseeked(String onseeked) {
		getStateHelper().put(MediaPropertyKeys.onseeked, onseeked);
	}

	/**
	 * <code>onseeking</code> attribute description:
	 * <br /><br />
	 * Javascript to execute when a seeking event occurs.
	 */
	public String getOnseeking() {
		return (String) getStateHelper().eval(MediaPropertyKeys.onseeking, null);
	}

	/**
	 * <code>onseeking</code> attribute description:
	 * <br /><br />
	 * Javascript to execute when a seeking event occurs.
	 */
	public void setOnseeking(String onseeking) {
		getStateHelper().put(MediaPropertyKeys.onseeking, onseeking);
	}

	/**
	 * <code>onstalled</code> attribute description:
	 * <br /><br />
	 * Javascript to execute when a stalled event occurs.
	 */
	public String getOnstalled() {
		return (String) getStateHelper().eval(MediaPropertyKeys.onstalled, null);
	}

	/**
	 * <code>onstalled</code> attribute description:
	 * <br /><br />
	 * Javascript to execute when a stalled event occurs.
	 */
	public void setOnstalled(String onstalled) {
		getStateHelper().put(MediaPropertyKeys.onstalled, onstalled);
	}

	/**
	 * <code>onsuspend</code> attribute description:
	 * <br /><br />
	 * Javascript to execute when a suspend event occurs.
	 */
	public String getOnsuspend() {
		return (String) getStateHelper().eval(MediaPropertyKeys.onsuspend, null);
	}

	/**
	 * <code>onsuspend</code> attribute description:
	 * <br /><br />
	 * Javascript to execute when a suspend event occurs.
	 */
	public void setOnsuspend(String onsuspend) {
		getStateHelper().put(MediaPropertyKeys.onsuspend, onsuspend);
	}

	/**
	 * <code>ontimeupdate</code> attribute description:
	 * <br /><br />
	 * Javascript to execute when a timeupdate event occurs.
	 */
	public String getOntimeupdate() {
		return (String) getStateHelper().eval(MediaPropertyKeys.ontimeupdate, null);
	}

	/**
	 * <code>ontimeupdate</code> attribute description:
	 * <br /><br />
	 * Javascript to execute when a timeupdate event occurs.
	 */
	public void setOntimeupdate(String ontimeupdate) {
		getStateHelper().put(MediaPropertyKeys.ontimeupdate, ontimeupdate);
	}

	/**
	 * <code>onvolumechange</code> attribute description:
	 * <br /><br />
	 * Javascript to execute when a volumechange event occurs.
	 */
	public String getOnvolumechange() {
		return (String) getStateHelper().eval(MediaPropertyKeys.onvolumechange, null);
	}

	/**
	 * <code>onvolumechange</code> attribute description:
	 * <br /><br />
	 * Javascript to execute when a volumechange event occurs.
	 */
	public void setOnvolumechange(String onvolumechange) {
		getStateHelper().put(MediaPropertyKeys.onvolumechange, onvolumechange);
	}

	/**
	 * <code>onwaiting</code> attribute description:
	 * <br /><br />
	 * Javascript to execute when a waiting event occurs.
	 */
	public String getOnwaiting() {
		return (String) getStateHelper().eval(MediaPropertyKeys.onwaiting, null);
	}

	/**
	 * <code>onwaiting</code> attribute description:
	 * <br /><br />
	 * Javascript to execute when a waiting event occurs.
	 */
	public void setOnwaiting(String onwaiting) {
		getStateHelper().put(MediaPropertyKeys.onwaiting, onwaiting);
	}

	/**
	 * <code>preload</code> attribute description:
	 * <br /><br />
	 * HTML5 passthrough attribute specifying how the media should be loaded in the page.
	 */
	public String getPreload() {
		return (String) getStateHelper().eval(MediaPropertyKeys.preload, null);
	}

	/**
	 * <code>preload</code> attribute description:
	 * <br /><br />
	 * HTML5 passthrough attribute specifying how the media should be loaded in the page.
	 */
	public void setPreload(String preload) {
		getStateHelper().put(MediaPropertyKeys.preload, preload);
	}

	/**
	 * <code>style</code> attribute description:
	 * <br /><br />
	 * HTML passthrough attribute specifying the css style of the element.
	 */
	public String getStyle() {
		return (String) getStateHelper().eval(MediaPropertyKeys.style, null);
	}

	/**
	 * <code>style</code> attribute description:
	 * <br /><br />
	 * HTML passthrough attribute specifying the css style of the element.
	 */
	public void setStyle(String style) {
		getStateHelper().put(MediaPropertyKeys.style, style);
	}

	/**
	 * <code>value</code> attribute description:
	 * <br /><br />
	 * A context-relative path, resource URL, <code>FacesResource</code>, or <code>List&lt;FacesResouce&gt;</code> that can be used to retrieve the media(s).
	 */
	public Object getValue() {
		return (Object) getStateHelper().eval(MediaPropertyKeys.value, null);
	}

	/**
	 * <code>value</code> attribute description:
	 * <br /><br />
	 * A context-relative path, resource URL, <code>FacesResource</code>, or <code>List&lt;FacesResouce&gt;</code> that can be used to retrieve the media(s).
	 */
	public void setValue(Object value) {
		getStateHelper().put(MediaPropertyKeys.value, value);
	}
}
//J+
