/**
 * Copyright (c) 2000-2020 Liferay, Inc. All rights reserved.
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
	 * <p><code>autoplay</code> attribute description:</p>
	 *
	 * <div>HTML5 passthrough attribute specifying whether the media will begin playing automatically.</div>
	 */
	public boolean isAutoplay() {
		return (Boolean) getStateHelper().eval(MediaPropertyKeys.autoplay, false);
	}

	/**
	 * <p><code>autoplay</code> attribute description:</p>
	 *
	 * <div>HTML5 passthrough attribute specifying whether the media will begin playing automatically.</div>
	 */
	public void setAutoplay(boolean autoplay) {
		getStateHelper().put(MediaPropertyKeys.autoplay, autoplay);
	}

	/**
	 * <p><code>contentType</code> attribute description:</p>
	 *
	 * <div>The content type of the media. This attribute is required when the <code>value</code> attribute is used to specify the media URL. Otherwise, the contentType defaults to to the content type determined by the JSF runtime for the resource.</div>
	 */
	public String getContentType() {
		return (String) getStateHelper().eval(MediaPropertyKeys.contentType, null);
	}

	/**
	 * <p><code>contentType</code> attribute description:</p>
	 *
	 * <div>The content type of the media. This attribute is required when the <code>value</code> attribute is used to specify the media URL. Otherwise, the contentType defaults to to the content type determined by the JSF runtime for the resource.</div>
	 */
	public void setContentType(String contentType) {
		getStateHelper().put(MediaPropertyKeys.contentType, contentType);
	}

	/**
	 * <p><code>controls</code> attribute description:</p>
	 *
	 * <div>HTML5 passthrough attribute specifying whether controls should be rendered for the media.</div>
	 */
	public boolean isControls() {
		return (Boolean) getStateHelper().eval(MediaPropertyKeys.controls, false);
	}

	/**
	 * <p><code>controls</code> attribute description:</p>
	 *
	 * <div>HTML5 passthrough attribute specifying whether controls should be rendered for the media.</div>
	 */
	public void setControls(boolean controls) {
		getStateHelper().put(MediaPropertyKeys.controls, controls);
	}

	/**
	 * <p><code>degrade</code> attribute description:</p>
	 *
	 * <div>When true the component will gracefully degrade to the Adobe&reg; Flash&reg; player for older browsers.</div>
	 */
	public boolean isDegrade() {
		return (Boolean) getStateHelper().eval(MediaPropertyKeys.degrade, true);
	}

	/**
	 * <p><code>degrade</code> attribute description:</p>
	 *
	 * <div>When true the component will gracefully degrade to the Adobe&reg; Flash&reg; player for older browsers.</div>
	 */
	public void setDegrade(boolean degrade) {
		getStateHelper().put(MediaPropertyKeys.degrade, degrade);
	}

	/**
	 * <p><code>flashPlayer</code> attribute description:</p>
	 *
	 * <div>A context-relative path, resource URL, or FacesResource that can be used to retrieve the Adobe&reg; Flash&reg; player. The default flash player is the flash player bundled with AlloyUI. <strong>Note:</strong> The AlloyUI player does not support <code>.ogv</code> or <code>.webm</code> formats.</div>
	 */
	public Object getFlashPlayer() {
		return (Object) getStateHelper().eval(MediaPropertyKeys.flashPlayer, null);
	}

	/**
	 * <p><code>flashPlayer</code> attribute description:</p>
	 *
	 * <div>A context-relative path, resource URL, or FacesResource that can be used to retrieve the Adobe&reg; Flash&reg; player. The default flash player is the flash player bundled with AlloyUI. <strong>Note:</strong> The AlloyUI player does not support <code>.ogv</code> or <code>.webm</code> formats.</div>
	 */
	public void setFlashPlayer(Object flashPlayer) {
		getStateHelper().put(MediaPropertyKeys.flashPlayer, flashPlayer);
	}

	/**
	 * <p><code>flashPlayerVersion</code> attribute description:</p>
	 *
	 * <div>The version of Adobe&reg; Flash&reg; required to play this media.</div>
	 */
	public String getFlashPlayerVersion() {
		return (String) getStateHelper().eval(MediaPropertyKeys.flashPlayerVersion, "9,0,0,0");
	}

	/**
	 * <p><code>flashPlayerVersion</code> attribute description:</p>
	 *
	 * <div>The version of Adobe&reg; Flash&reg; required to play this media.</div>
	 */
	public void setFlashPlayerVersion(String flashPlayerVersion) {
		getStateHelper().put(MediaPropertyKeys.flashPlayerVersion, flashPlayerVersion);
	}

	/**
	 * <p><code>library</code> attribute description:</p>
	 *
	 * <div>The name of the library which contains the resource.</div>
	 */
	public String getLibrary() {
		return (String) getStateHelper().eval(MediaPropertyKeys.library, null);
	}

	/**
	 * <p><code>library</code> attribute description:</p>
	 *
	 * <div>The name of the library which contains the resource.</div>
	 */
	public void setLibrary(String library) {
		getStateHelper().put(MediaPropertyKeys.library, library);
	}

	/**
	 * <p><code>loop</code> attribute description:</p>
	 *
	 * <div>HTML5 passthrough attribute specifying whether the media will restart after it has completed playing.</div>
	 */
	public boolean isLoop() {
		return (Boolean) getStateHelper().eval(MediaPropertyKeys.loop, false);
	}

	/**
	 * <p><code>loop</code> attribute description:</p>
	 *
	 * <div>HTML5 passthrough attribute specifying whether the media will restart after it has completed playing.</div>
	 */
	public void setLoop(boolean loop) {
		getStateHelper().put(MediaPropertyKeys.loop, loop);
	}

	/**
	 * <p><code>muted</code> attribute description:</p>
	 *
	 * <div>HTML5 passthrough attribute specifying whether the media will be muted initially.</div>
	 */
	public boolean isMuted() {
		return (Boolean) getStateHelper().eval(MediaPropertyKeys.muted, false);
	}

	/**
	 * <p><code>muted</code> attribute description:</p>
	 *
	 * <div>HTML5 passthrough attribute specifying whether the media will be muted initially.</div>
	 */
	public void setMuted(boolean muted) {
		getStateHelper().put(MediaPropertyKeys.muted, muted);
	}

	/**
	 * <p><code>name</code> attribute description:</p>
	 *
	 * <div>The name of the resource file to be included on the page.</div>
	 */
	public String getName() {
		return (String) getStateHelper().eval(MediaPropertyKeys.name, null);
	}

	/**
	 * <p><code>name</code> attribute description:</p>
	 *
	 * <div>The name of the resource file to be included on the page.</div>
	 */
	public void setName(String name) {
		getStateHelper().put(MediaPropertyKeys.name, name);
	}

	/**
	 * <p><code>onabort</code> attribute description:</p>
	 *
	 * <div>Javascript to execute when a abort event occurs.</div>
	 */
	public String getOnabort() {
		return (String) getStateHelper().eval(MediaPropertyKeys.onabort, null);
	}

	/**
	 * <p><code>onabort</code> attribute description:</p>
	 *
	 * <div>Javascript to execute when a abort event occurs.</div>
	 */
	public void setOnabort(String onabort) {
		getStateHelper().put(MediaPropertyKeys.onabort, onabort);
	}

	/**
	 * <p><code>onblur</code> attribute description:</p>
	 *
	 * <div>Javascript to execute after this component loses focus.</div>
	 */
	public String getOnblur() {
		return (String) getStateHelper().eval(MediaPropertyKeys.onblur, null);
	}

	/**
	 * <p><code>onblur</code> attribute description:</p>
	 *
	 * <div>Javascript to execute after this component loses focus.</div>
	 */
	public void setOnblur(String onblur) {
		getStateHelper().put(MediaPropertyKeys.onblur, onblur);
	}

	/**
	 * <p><code>oncanplay</code> attribute description:</p>
	 *
	 * <div>Javascript to execute when a canplay event occurs.</div>
	 */
	public String getOncanplay() {
		return (String) getStateHelper().eval(MediaPropertyKeys.oncanplay, null);
	}

	/**
	 * <p><code>oncanplay</code> attribute description:</p>
	 *
	 * <div>Javascript to execute when a canplay event occurs.</div>
	 */
	public void setOncanplay(String oncanplay) {
		getStateHelper().put(MediaPropertyKeys.oncanplay, oncanplay);
	}

	/**
	 * <p><code>oncanplaythrough</code> attribute description:</p>
	 *
	 * <div>Javascript to execute when a canplaythrough event occurs.</div>
	 */
	public String getOncanplaythrough() {
		return (String) getStateHelper().eval(MediaPropertyKeys.oncanplaythrough, null);
	}

	/**
	 * <p><code>oncanplaythrough</code> attribute description:</p>
	 *
	 * <div>Javascript to execute when a canplaythrough event occurs.</div>
	 */
	public void setOncanplaythrough(String oncanplaythrough) {
		getStateHelper().put(MediaPropertyKeys.oncanplaythrough, oncanplaythrough);
	}

	/**
	 * <p><code>onclick</code> attribute description:</p>
	 *
	 * <div>Javascript to execute when this component is clicked.</div>
	 */
	public String getOnclick() {
		return (String) getStateHelper().eval(MediaPropertyKeys.onclick, null);
	}

	/**
	 * <p><code>onclick</code> attribute description:</p>
	 *
	 * <div>Javascript to execute when this component is clicked.</div>
	 */
	public void setOnclick(String onclick) {
		getStateHelper().put(MediaPropertyKeys.onclick, onclick);
	}

	/**
	 * <p><code>ondblclick</code> attribute description:</p>
	 *
	 * <div>Javascript to execute when a double click event occurs.</div>
	 */
	public String getOndblclick() {
		return (String) getStateHelper().eval(MediaPropertyKeys.ondblclick, null);
	}

	/**
	 * <p><code>ondblclick</code> attribute description:</p>
	 *
	 * <div>Javascript to execute when a double click event occurs.</div>
	 */
	public void setOndblclick(String ondblclick) {
		getStateHelper().put(MediaPropertyKeys.ondblclick, ondblclick);
	}

	/**
	 * <p><code>ondurationchange</code> attribute description:</p>
	 *
	 * <div>Javascript to execute when a durationchange event occurs.</div>
	 */
	public String getOndurationchange() {
		return (String) getStateHelper().eval(MediaPropertyKeys.ondurationchange, null);
	}

	/**
	 * <p><code>ondurationchange</code> attribute description:</p>
	 *
	 * <div>Javascript to execute when a durationchange event occurs.</div>
	 */
	public void setOndurationchange(String ondurationchange) {
		getStateHelper().put(MediaPropertyKeys.ondurationchange, ondurationchange);
	}

	/**
	 * <p><code>onemptied</code> attribute description:</p>
	 *
	 * <div>Javascript to execute when a emptied event occurs.</div>
	 */
	public String getOnemptied() {
		return (String) getStateHelper().eval(MediaPropertyKeys.onemptied, null);
	}

	/**
	 * <p><code>onemptied</code> attribute description:</p>
	 *
	 * <div>Javascript to execute when a emptied event occurs.</div>
	 */
	public void setOnemptied(String onemptied) {
		getStateHelper().put(MediaPropertyKeys.onemptied, onemptied);
	}

	/**
	 * <p><code>onended</code> attribute description:</p>
	 *
	 * <div>Javascript to execute when a ended event occurs.</div>
	 */
	public String getOnended() {
		return (String) getStateHelper().eval(MediaPropertyKeys.onended, null);
	}

	/**
	 * <p><code>onended</code> attribute description:</p>
	 *
	 * <div>Javascript to execute when a ended event occurs.</div>
	 */
	public void setOnended(String onended) {
		getStateHelper().put(MediaPropertyKeys.onended, onended);
	}

	/**
	 * <p><code>onerror</code> attribute description:</p>
	 *
	 * <div>Javascript to execute when a error event occurs.</div>
	 */
	public String getOnerror() {
		return (String) getStateHelper().eval(MediaPropertyKeys.onerror, null);
	}

	/**
	 * <p><code>onerror</code> attribute description:</p>
	 *
	 * <div>Javascript to execute when a error event occurs.</div>
	 */
	public void setOnerror(String onerror) {
		getStateHelper().put(MediaPropertyKeys.onerror, onerror);
	}

	/**
	 * <p><code>onfocus</code> attribute description:</p>
	 *
	 * <div>Javascript to execute when this component gets focus.</div>
	 */
	public String getOnfocus() {
		return (String) getStateHelper().eval(MediaPropertyKeys.onfocus, null);
	}

	/**
	 * <p><code>onfocus</code> attribute description:</p>
	 *
	 * <div>Javascript to execute when this component gets focus.</div>
	 */
	public void setOnfocus(String onfocus) {
		getStateHelper().put(MediaPropertyKeys.onfocus, onfocus);
	}

	/**
	 * <p><code>onkeydown</code> attribute description:</p>
	 *
	 * <div>Javascript to execute when a keydown event occurs.</div>
	 */
	public String getOnkeydown() {
		return (String) getStateHelper().eval(MediaPropertyKeys.onkeydown, null);
	}

	/**
	 * <p><code>onkeydown</code> attribute description:</p>
	 *
	 * <div>Javascript to execute when a keydown event occurs.</div>
	 */
	public void setOnkeydown(String onkeydown) {
		getStateHelper().put(MediaPropertyKeys.onkeydown, onkeydown);
	}

	/**
	 * <p><code>onkeypress</code> attribute description:</p>
	 *
	 * <div>Javascript to execute when a keypress event occurs.</div>
	 */
	public String getOnkeypress() {
		return (String) getStateHelper().eval(MediaPropertyKeys.onkeypress, null);
	}

	/**
	 * <p><code>onkeypress</code> attribute description:</p>
	 *
	 * <div>Javascript to execute when a keypress event occurs.</div>
	 */
	public void setOnkeypress(String onkeypress) {
		getStateHelper().put(MediaPropertyKeys.onkeypress, onkeypress);
	}

	/**
	 * <p><code>onkeyup</code> attribute description:</p>
	 *
	 * <div>Javascript to execute when a keyup event occurs.</div>
	 */
	public String getOnkeyup() {
		return (String) getStateHelper().eval(MediaPropertyKeys.onkeyup, null);
	}

	/**
	 * <p><code>onkeyup</code> attribute description:</p>
	 *
	 * <div>Javascript to execute when a keyup event occurs.</div>
	 */
	public void setOnkeyup(String onkeyup) {
		getStateHelper().put(MediaPropertyKeys.onkeyup, onkeyup);
	}

	/**
	 * <p><code>onloadeddata</code> attribute description:</p>
	 *
	 * <div>Javascript to execute when a loadeddata event occurs.</div>
	 */
	public String getOnloadeddata() {
		return (String) getStateHelper().eval(MediaPropertyKeys.onloadeddata, null);
	}

	/**
	 * <p><code>onloadeddata</code> attribute description:</p>
	 *
	 * <div>Javascript to execute when a loadeddata event occurs.</div>
	 */
	public void setOnloadeddata(String onloadeddata) {
		getStateHelper().put(MediaPropertyKeys.onloadeddata, onloadeddata);
	}

	/**
	 * <p><code>onloadedmetadata</code> attribute description:</p>
	 *
	 * <div>Javascript to execute when a loadedmetadata event occurs.</div>
	 */
	public String getOnloadedmetadata() {
		return (String) getStateHelper().eval(MediaPropertyKeys.onloadedmetadata, null);
	}

	/**
	 * <p><code>onloadedmetadata</code> attribute description:</p>
	 *
	 * <div>Javascript to execute when a loadedmetadata event occurs.</div>
	 */
	public void setOnloadedmetadata(String onloadedmetadata) {
		getStateHelper().put(MediaPropertyKeys.onloadedmetadata, onloadedmetadata);
	}

	/**
	 * <p><code>onloadstart</code> attribute description:</p>
	 *
	 * <div>Javascript to execute when a loadstart event occurs.</div>
	 */
	public String getOnloadstart() {
		return (String) getStateHelper().eval(MediaPropertyKeys.onloadstart, null);
	}

	/**
	 * <p><code>onloadstart</code> attribute description:</p>
	 *
	 * <div>Javascript to execute when a loadstart event occurs.</div>
	 */
	public void setOnloadstart(String onloadstart) {
		getStateHelper().put(MediaPropertyKeys.onloadstart, onloadstart);
	}

	/**
	 * <p><code>onmousedown</code> attribute description:</p>
	 *
	 * <div>Javascript to execute when a mousedown event occurs.</div>
	 */
	public String getOnmousedown() {
		return (String) getStateHelper().eval(MediaPropertyKeys.onmousedown, null);
	}

	/**
	 * <p><code>onmousedown</code> attribute description:</p>
	 *
	 * <div>Javascript to execute when a mousedown event occurs.</div>
	 */
	public void setOnmousedown(String onmousedown) {
		getStateHelper().put(MediaPropertyKeys.onmousedown, onmousedown);
	}

	/**
	 * <p><code>onmousemove</code> attribute description:</p>
	 *
	 * <div>Javascript to execute when a mousemove event occurs.</div>
	 */
	public String getOnmousemove() {
		return (String) getStateHelper().eval(MediaPropertyKeys.onmousemove, null);
	}

	/**
	 * <p><code>onmousemove</code> attribute description:</p>
	 *
	 * <div>Javascript to execute when a mousemove event occurs.</div>
	 */
	public void setOnmousemove(String onmousemove) {
		getStateHelper().put(MediaPropertyKeys.onmousemove, onmousemove);
	}

	/**
	 * <p><code>onmouseout</code> attribute description:</p>
	 *
	 * <div>Javascript to execute when a mouseout event occurs.</div>
	 */
	public String getOnmouseout() {
		return (String) getStateHelper().eval(MediaPropertyKeys.onmouseout, null);
	}

	/**
	 * <p><code>onmouseout</code> attribute description:</p>
	 *
	 * <div>Javascript to execute when a mouseout event occurs.</div>
	 */
	public void setOnmouseout(String onmouseout) {
		getStateHelper().put(MediaPropertyKeys.onmouseout, onmouseout);
	}

	/**
	 * <p><code>onmouseover</code> attribute description:</p>
	 *
	 * <div>Javascript to execute when a mouseover event occurs.</div>
	 */
	public String getOnmouseover() {
		return (String) getStateHelper().eval(MediaPropertyKeys.onmouseover, null);
	}

	/**
	 * <p><code>onmouseover</code> attribute description:</p>
	 *
	 * <div>Javascript to execute when a mouseover event occurs.</div>
	 */
	public void setOnmouseover(String onmouseover) {
		getStateHelper().put(MediaPropertyKeys.onmouseover, onmouseover);
	}

	/**
	 * <p><code>onmouseup</code> attribute description:</p>
	 *
	 * <div>Javascript to execute when a mouseup event occurs.</div>
	 */
	public String getOnmouseup() {
		return (String) getStateHelper().eval(MediaPropertyKeys.onmouseup, null);
	}

	/**
	 * <p><code>onmouseup</code> attribute description:</p>
	 *
	 * <div>Javascript to execute when a mouseup event occurs.</div>
	 */
	public void setOnmouseup(String onmouseup) {
		getStateHelper().put(MediaPropertyKeys.onmouseup, onmouseup);
	}

	/**
	 * <p><code>onpause</code> attribute description:</p>
	 *
	 * <div>Javascript to execute when a pause event occurs.</div>
	 */
	public String getOnpause() {
		return (String) getStateHelper().eval(MediaPropertyKeys.onpause, null);
	}

	/**
	 * <p><code>onpause</code> attribute description:</p>
	 *
	 * <div>Javascript to execute when a pause event occurs.</div>
	 */
	public void setOnpause(String onpause) {
		getStateHelper().put(MediaPropertyKeys.onpause, onpause);
	}

	/**
	 * <p><code>onplay</code> attribute description:</p>
	 *
	 * <div>Javascript to execute when a play event occurs.</div>
	 */
	public String getOnplay() {
		return (String) getStateHelper().eval(MediaPropertyKeys.onplay, null);
	}

	/**
	 * <p><code>onplay</code> attribute description:</p>
	 *
	 * <div>Javascript to execute when a play event occurs.</div>
	 */
	public void setOnplay(String onplay) {
		getStateHelper().put(MediaPropertyKeys.onplay, onplay);
	}

	/**
	 * <p><code>onplaying</code> attribute description:</p>
	 *
	 * <div>Javascript to execute when a playing event occurs.</div>
	 */
	public String getOnplaying() {
		return (String) getStateHelper().eval(MediaPropertyKeys.onplaying, null);
	}

	/**
	 * <p><code>onplaying</code> attribute description:</p>
	 *
	 * <div>Javascript to execute when a playing event occurs.</div>
	 */
	public void setOnplaying(String onplaying) {
		getStateHelper().put(MediaPropertyKeys.onplaying, onplaying);
	}

	/**
	 * <p><code>onprogress</code> attribute description:</p>
	 *
	 * <div>Javascript to execute when a progress event occurs.</div>
	 */
	public String getOnprogress() {
		return (String) getStateHelper().eval(MediaPropertyKeys.onprogress, null);
	}

	/**
	 * <p><code>onprogress</code> attribute description:</p>
	 *
	 * <div>Javascript to execute when a progress event occurs.</div>
	 */
	public void setOnprogress(String onprogress) {
		getStateHelper().put(MediaPropertyKeys.onprogress, onprogress);
	}

	/**
	 * <p><code>onratechange</code> attribute description:</p>
	 *
	 * <div>Javascript to execute when a ratechange event occurs.</div>
	 */
	public String getOnratechange() {
		return (String) getStateHelper().eval(MediaPropertyKeys.onratechange, null);
	}

	/**
	 * <p><code>onratechange</code> attribute description:</p>
	 *
	 * <div>Javascript to execute when a ratechange event occurs.</div>
	 */
	public void setOnratechange(String onratechange) {
		getStateHelper().put(MediaPropertyKeys.onratechange, onratechange);
	}

	/**
	 * <p><code>onseeked</code> attribute description:</p>
	 *
	 * <div>Javascript to execute when a seeked event occurs.</div>
	 */
	public String getOnseeked() {
		return (String) getStateHelper().eval(MediaPropertyKeys.onseeked, null);
	}

	/**
	 * <p><code>onseeked</code> attribute description:</p>
	 *
	 * <div>Javascript to execute when a seeked event occurs.</div>
	 */
	public void setOnseeked(String onseeked) {
		getStateHelper().put(MediaPropertyKeys.onseeked, onseeked);
	}

	/**
	 * <p><code>onseeking</code> attribute description:</p>
	 *
	 * <div>Javascript to execute when a seeking event occurs.</div>
	 */
	public String getOnseeking() {
		return (String) getStateHelper().eval(MediaPropertyKeys.onseeking, null);
	}

	/**
	 * <p><code>onseeking</code> attribute description:</p>
	 *
	 * <div>Javascript to execute when a seeking event occurs.</div>
	 */
	public void setOnseeking(String onseeking) {
		getStateHelper().put(MediaPropertyKeys.onseeking, onseeking);
	}

	/**
	 * <p><code>onstalled</code> attribute description:</p>
	 *
	 * <div>Javascript to execute when a stalled event occurs.</div>
	 */
	public String getOnstalled() {
		return (String) getStateHelper().eval(MediaPropertyKeys.onstalled, null);
	}

	/**
	 * <p><code>onstalled</code> attribute description:</p>
	 *
	 * <div>Javascript to execute when a stalled event occurs.</div>
	 */
	public void setOnstalled(String onstalled) {
		getStateHelper().put(MediaPropertyKeys.onstalled, onstalled);
	}

	/**
	 * <p><code>onsuspend</code> attribute description:</p>
	 *
	 * <div>Javascript to execute when a suspend event occurs.</div>
	 */
	public String getOnsuspend() {
		return (String) getStateHelper().eval(MediaPropertyKeys.onsuspend, null);
	}

	/**
	 * <p><code>onsuspend</code> attribute description:</p>
	 *
	 * <div>Javascript to execute when a suspend event occurs.</div>
	 */
	public void setOnsuspend(String onsuspend) {
		getStateHelper().put(MediaPropertyKeys.onsuspend, onsuspend);
	}

	/**
	 * <p><code>ontimeupdate</code> attribute description:</p>
	 *
	 * <div>Javascript to execute when a timeupdate event occurs.</div>
	 */
	public String getOntimeupdate() {
		return (String) getStateHelper().eval(MediaPropertyKeys.ontimeupdate, null);
	}

	/**
	 * <p><code>ontimeupdate</code> attribute description:</p>
	 *
	 * <div>Javascript to execute when a timeupdate event occurs.</div>
	 */
	public void setOntimeupdate(String ontimeupdate) {
		getStateHelper().put(MediaPropertyKeys.ontimeupdate, ontimeupdate);
	}

	/**
	 * <p><code>onvolumechange</code> attribute description:</p>
	 *
	 * <div>Javascript to execute when a volumechange event occurs.</div>
	 */
	public String getOnvolumechange() {
		return (String) getStateHelper().eval(MediaPropertyKeys.onvolumechange, null);
	}

	/**
	 * <p><code>onvolumechange</code> attribute description:</p>
	 *
	 * <div>Javascript to execute when a volumechange event occurs.</div>
	 */
	public void setOnvolumechange(String onvolumechange) {
		getStateHelper().put(MediaPropertyKeys.onvolumechange, onvolumechange);
	}

	/**
	 * <p><code>onwaiting</code> attribute description:</p>
	 *
	 * <div>Javascript to execute when a waiting event occurs.</div>
	 */
	public String getOnwaiting() {
		return (String) getStateHelper().eval(MediaPropertyKeys.onwaiting, null);
	}

	/**
	 * <p><code>onwaiting</code> attribute description:</p>
	 *
	 * <div>Javascript to execute when a waiting event occurs.</div>
	 */
	public void setOnwaiting(String onwaiting) {
		getStateHelper().put(MediaPropertyKeys.onwaiting, onwaiting);
	}

	/**
	 * <p><code>preload</code> attribute description:</p>
	 *
	 * <div>HTML5 passthrough attribute specifying how the media should be loaded in the page.</div>
	 */
	public String getPreload() {
		return (String) getStateHelper().eval(MediaPropertyKeys.preload, null);
	}

	/**
	 * <p><code>preload</code> attribute description:</p>
	 *
	 * <div>HTML5 passthrough attribute specifying how the media should be loaded in the page.</div>
	 */
	public void setPreload(String preload) {
		getStateHelper().put(MediaPropertyKeys.preload, preload);
	}

	/**
	 * <p><code>style</code> attribute description:</p>
	 *
	 * <div>HTML passthrough attribute specifying the css style of the element.</div>
	 */
	public String getStyle() {
		return (String) getStateHelper().eval(MediaPropertyKeys.style, null);
	}

	/**
	 * <p><code>style</code> attribute description:</p>
	 *
	 * <div>HTML passthrough attribute specifying the css style of the element.</div>
	 */
	public void setStyle(String style) {
		getStateHelper().put(MediaPropertyKeys.style, style);
	}

	/**
	 * <p><code>value</code> attribute description:</p>
	 *
	 * <div>A context-relative path, resource URL, <code>FacesResource</code>, or <code>List&lt;FacesResouce&gt;</code> that can be used to retrieve the media(s).</div>
	 */
	public Object getValue() {
		return (Object) getStateHelper().eval(MediaPropertyKeys.value, null);
	}

	/**
	 * <p><code>value</code> attribute description:</p>
	 *
	 * <div>A context-relative path, resource URL, <code>FacesResource</code>, or <code>List&lt;FacesResouce&gt;</code> that can be used to retrieve the media(s).</div>
	 */
	public void setValue(Object value) {
		getStateHelper().put(MediaPropertyKeys.value, value);
	}
}
//J+
