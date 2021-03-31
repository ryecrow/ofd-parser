package org.ofdspec

import jakarta.xml.bind.annotation.XmlRegistry
import org.ofdspec.CTAction.*
import org.ofdspec.CTAction.Goto.Bookmark
import org.ofdspec.CTColorSpace.Palette
import org.ofdspec.CTDocInfo.CustomDatas
import org.ofdspec.CTDocInfo.CustomDatas.CustomData
import org.ofdspec.CTGraphicUnit.Clips
import org.ofdspec.CTPageBlock.*
import org.ofdspec.CTPattern.CellContent
import org.ofdspec.CTPermission.ValidPeriod
import org.ofdspec.CTRegion.Area.*
import org.ofdspec.CTText.TextCode
import org.ofdspec.CustomTags.CustomTag
import org.ofdspec.DocVersion.FileList
import org.ofdspec.Document.*
import org.ofdspec.Document.CommonData.TemplatePage
import org.ofdspec.OFD.DocBody
import org.ofdspec.Page.Content.Layer
import org.ofdspec.PageAnnot.Annot
import org.ofdspec.PageAnnot.Annot.Appearance
import org.ofdspec.Res.*
import org.ofdspec.Res.CompositeGraphicUnits.CompositeGraphicUnit
import org.ofdspec.Res.DrawParams.DrawParam
import org.ofdspec.Res.MultiMedias.MultiMedia
import org.ofdspec.Signature.SignedInfo.*

@XmlRegistry
class ObjectFactory {

    fun createPageAnnot(): PageAnnot {
        return PageAnnot()
    }


    fun createCustomTags(): CustomTags {
        return CustomTags()
    }


    fun createDocVersion(): DocVersion {
        return DocVersion()
    }


    fun createRes(): Res {
        return Res()
    }


    fun createSignature(): Signature {
        return Signature()
    }


    fun createPage(): Page {
        return Page()
    }


    fun createDocument(): Document {
        return Document()
    }


    fun createOFD(): OFD {
        return OFD()
    }


    fun createSignatures(): Signatures {
        return Signatures()
    }


    fun createCTDocInfo(): CTDocInfo {
        return CTDocInfo()
    }


    fun createCTDocInfoCustomDatas(): CustomDatas {
        return CustomDatas()
    }


    fun createCTAction(): CTAction {
        return CTAction()
    }


    fun createCTActionGoto(): Goto {
        return Goto()
    }


    fun createCTLaGouraudShd(): CTLaGouraudShd {
        return CTLaGouraudShd()
    }


    fun createCTOutlineElem(): CTOutlineElem {
        return CTOutlineElem()
    }


    fun createCTPattern(): CTPattern {
        return CTPattern()
    }


    fun createCTPageBlock(): CTPageBlock {
        return CTPageBlock()
    }


    fun createCTImage(): CTImage {
        return CTImage()
    }


    fun createCTText(): CTText {
        return CTText()
    }


    fun createCTColorSpace(): CTColorSpace {
        return CTColorSpace()
    }


    fun createCTRadialShd(): CTRadialShd {
        return CTRadialShd()
    }


    fun createCTClip(): CTClip {
        return CTClip()
    }


    fun createCTRegion(): CTRegion {
        return CTRegion()
    }


    fun createCTRegionArea(): CTRegion.Area {
        return CTRegion.Area()
    }


    fun createCTAxialShd(): CTAxialShd {
        return CTAxialShd()
    }


    fun createCTGouraudShd(): CTGouraudShd {
        return CTGouraudShd()
    }


    fun createOFDDocBody(): DocBody {
        return DocBody()
    }


    fun createOFDDocBodyVersions(): DocBody.Versions {
        return DocBody.Versions()
    }


    fun createCTExtension(): CTExtension {
        return CTExtension()
    }


    fun createCTPermission(): CTPermission {
        return CTPermission()
    }


    fun createDocumentPages(): Pages {
        return Pages()
    }


    fun createDocumentCommonData(): CommonData {
        return CommonData()
    }


    fun createPageContent(): Page.Content {
        return Page.Content()
    }


    fun createSignatureSignedInfo(): Signature.SignedInfo {
        return Signature.SignedInfo()
    }


    fun createSignatureSignedInfoReferences(): References {
        return References()
    }


    fun createResCompositeGraphicUnits(): CompositeGraphicUnits {
        return CompositeGraphicUnits()
    }


    fun createResMultiMedias(): MultiMedias {
        return MultiMedias()
    }


    fun createResFonts(): Fonts {
        return Fonts()
    }


    fun createResDrawParams(): DrawParams {
        return DrawParams()
    }


    fun createResColorSpaces(): ColorSpaces {
        return ColorSpaces()
    }


    fun createDocVersionFileList(): FileList {
        return FileList()
    }


    fun createPageAnnotAnnot(): Annot {
        return Annot()
    }


    fun createPageAnnotAnnotParameters(): Annot.Parameters {
        return Annot.Parameters()
    }


    fun createCustomTagsCustomTag(): CustomTag {
        return CustomTag()
    }


    fun createPageTemplate(): Page.Template {
        return Page.Template()
    }


    fun createCTPageArea(): CTPageArea {
        return CTPageArea()
    }


    fun createPageActions(): Page.Actions {
        return Page.Actions()
    }


    fun createDocumentOutlines(): Outlines {
        return Outlines()
    }


    fun createDocumentActions(): Document.Actions {
        return Document.Actions()
    }


    fun createCTVPreferences(): CTVPreferences {
        return CTVPreferences()
    }


    fun createDocumentBookmarks(): Bookmarks {
        return Bookmarks()
    }


    fun createExtensions(): Extensions {
        return Extensions()
    }


    fun createSignaturesSignature(): Signatures.Signature {
        return Signatures.Signature()
    }


    fun createAttachments(): Attachments {
        return Attachments()
    }


    fun createCTAttachment(): CTAttachment {
        return CTAttachment()
    }


    fun createCTCGTransform(): CTCGTransform {
        return CTCGTransform()
    }


    fun createCTFont(): CTFont {
        return CTFont()
    }


    fun createCTColor(): CTColor {
        return CTColor()
    }


    fun createCTLayer(): CTLayer {
        return CTLayer()
    }


    fun createCTComposite(): CTComposite {
        return CTComposite()
    }


    fun createCTBookmark(): CTBookmark {
        return CTBookmark()
    }


    fun createCTVectorG(): CTVectorG {
        return CTVectorG()
    }


    fun createCTDest(): CTDest {
        return CTDest()
    }


    fun createCTDrawParam(): CTDrawParam {
        return CTDrawParam()
    }


    fun createCTMultiMedia(): CTMultiMedia {
        return CTMultiMedia()
    }


    fun createCTPath(): CTPath {
        return CTPath()
    }


    fun createCTDocInfoKeywords(): CTDocInfo.Keywords {
        return CTDocInfo.Keywords()
    }


    fun createCTDocInfoCustomDatasCustomData(): CustomData {
        return CustomData()
    }


    fun createCTActionURI(): CTAction.URI {
        return CTAction.URI()
    }


    fun createCTActionGotoA(): GotoA {
        return GotoA()
    }


    fun createCTActionSound(): Sound {
        return Sound()
    }


    fun createCTActionMovie(): Movie {
        return Movie()
    }


    fun createCTActionGotoBookmark(): Bookmark {
        return Bookmark()
    }


    fun createCTLaGouraudShdPoint(): CTLaGouraudShd.Point {
        return CTLaGouraudShd.Point()
    }


    fun createCTOutlineElemActions(): CTOutlineElem.Actions {
        return CTOutlineElem.Actions()
    }


    fun createCTPatternCellContent(): CellContent {
        return CellContent()
    }


    fun createCTPageBlockTextObject(): TextObject {
        return TextObject()
    }


    fun createCTPageBlockPathObject(): PathObject {
        return PathObject()
    }


    fun createCTPageBlockImageObject(): ImageObject {
        return ImageObject()
    }


    fun createCTPageBlockCompositeObject(): CompositeObject {
        return CompositeObject()
    }


    fun createCTPageBlockPageBlock(): PageBlock {
        return PageBlock()
    }


    fun createCTGraphicUnitActions(): CTGraphicUnit.Actions {
        return CTGraphicUnit.Actions()
    }


    fun createCTGraphicUnitClips(): Clips {
        return Clips()
    }


    fun createCTImageBorder(): CTImage.Border {
        return CTImage.Border()
    }


    fun createCTTextTextCode(): TextCode {
        return TextCode()
    }


    fun createCTColorSpacePalette(): Palette {
        return Palette()
    }


    fun createCTRadialShdSegment(): CTRadialShd.Segment {
        return CTRadialShd.Segment()
    }


    fun createCTClipArea(): CTClip.Area {
        return CTClip.Area()
    }


    fun createCTRegionAreaMove(): CTRegion.Area.Move {
        return CTRegion.Area.Move()
    }


    fun createCTRegionAreaLine(): CTRegion.Area.Line {
        return CTRegion.Area.Line()
    }


    fun createCTRegionAreaQuadraticBezier(): QuadraticBezier {
        return QuadraticBezier()
    }


    fun createCTRegionAreaCubicBezier(): CubicBezier {
        return CubicBezier()
    }


    fun createCTRegionAreaArc(): Arc {
        return Arc()
    }


    fun createCTAxialShdSegment(): CTAxialShd.Segment {
        return CTAxialShd.Segment()
    }


    fun createCTGouraudShdPoint(): CTGouraudShd.Point {
        return CTGouraudShd.Point()
    }


    fun createOFDDocBodyVersionsVersion(): DocBody.Versions.Version {
        return DocBody.Versions.Version()
    }


    fun createCTExtensionProperty(): CTExtension.Property {
        return CTExtension.Property()
    }


    fun createCTPermissionPrint(): CTPermission.Print {
        return CTPermission.Print()
    }


    fun createCTPermissionValidPeriod(): ValidPeriod {
        return ValidPeriod()
    }


    fun createDocumentPagesPage(): Pages.Page {
        return Pages.Page()
    }


    fun createDocumentCommonDataTemplatePage(): TemplatePage {
        return TemplatePage()
    }


    fun createPageContentLayer(): Layer {
        return Layer()
    }


    fun createSignatureSignedInfoProvider(): Signature.SignedInfo.Provider {
        return Provider()
    }


    fun createSignatureSignedInfoStampAnnot(): StampAnnot {
        return StampAnnot()
    }


    fun createSignatureSignedInfoSeal(): Seal {
        return Seal()
    }


    fun createSignatureSignedInfoReferencesReference(): References.Reference {
        return References.Reference()
    }


    fun createResCompositeGraphicUnitsCompositeGraphicUnit(): CompositeGraphicUnit {
        return CompositeGraphicUnit()
    }


    fun createResMultiMediasMultiMedia(): MultiMedia {
        return MultiMedia()
    }


    fun createResFontsFont(): Fonts.Font {
        return Fonts.Font()
    }


    fun createResDrawParamsDrawParam(): DrawParam {
        return DrawParam()
    }


    fun createResColorSpacesColorSpace(): ColorSpaces.ColorSpace {
        return ColorSpaces.ColorSpace()
    }


    fun createDocVersionFileListFile(): FileList.File {
        return FileList.File()
    }


    fun createPageAnnotAnnotAppearance(): Appearance {
        return Appearance()
    }


    fun createPageAnnotAnnotParametersParameter(): Annot.Parameters.Parameter {
        return Annot.Parameters.Parameter()
    }
}