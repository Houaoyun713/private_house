import request from '@/utils/request'

// 查询参考材料列表
export function listRefma(query) {
  return request({
    url: '/refma/refma/list',
    method: 'get',
    params: query
  })
}

// 查询参考材料详细
export function getRefma(id) {
  return request({
    url: '/refma/refma/' + id,
    method: 'get'
  })
}

// 新增参考材料
export function addRefma(data) {
  return request({
    url: '/refma/refma',
    method: 'post',
    data: data
  })
}

// 修改参考材料
export function updateRefma(data) {
  return request({
    url: '/refma/refma',
    method: 'put',
    data: data
  })
}

// 删除参考材料
export function delRefma(id) {
  return request({
    url: '/refma/refma/' + id,
    method: 'delete'
  })
}
